package cn.sdcet.shop.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;

/**
 * �ļ��ϴ�������
 * 
 * @author 
 * 
 * <pre>
 * </pre>
 */
public class UploadUtils {
	/**
	 * ���ֶγ���
	 */
	public static final String FORM_FIELDS = "form_fields";
	/**
	 * �ļ�����
	 */
	public static final String FILE_FIELDS = "file_fields";

	// ����ļ���С
	private long maxSize = 1000000;
	// ���������ϴ����ļ���չ��
	private Map<String, String> extMap = new HashMap<String, String>();
	// �ļ�����Ŀ¼���·��
	private String basePath = "upload";
	// �ļ���Ŀ¼��
	private String dirName = "images";
	// �ϴ���ʱ·��
	private static final String TEMP_PATH = "/temp";
	private String tempPath = basePath + TEMP_PATH;
	// ����ָ�����ļ���Ĭ��Ϊ yyyyMMddHHmmss_xyz
	private String fileName;

	// �ļ�����Ŀ¼·��
	private String savePath;
	// �ļ�����Ŀ¼url
	private String saveUrl;
	// �ļ����յ�url�����ļ���
	private String fileUrl;
	private String finalUrl;
	
	private Map<String, String> formFields;

	public UploadUtils() {
		// ����images,flashs,medias,files,��Ӧ�ļ�������,��ӦdirName
		// key�ļ�������
		// value���ļ����ڿ����ϴ��ļ��ĺ�׺��
		extMap.put("images", "gif,jpg,jpeg,png,bmp");
		extMap.put("flashs", "swf,flv");
		extMap.put("medias", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("files", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
	}

	/**
	 * �ļ��ϴ�
	 * 
	 * @param request
	 * @return infos info[0] ��֤�ļ��򷵻ش�����Ϣ info[1] �ϴ��ļ�������Ϣ info[2] savePath info[3] saveUrl info[4] fileUrl
	 */
	@SuppressWarnings("unchecked")
	public String[] uploadFile(HttpServletRequest request) {
		String[] infos = new String[5];
		// ��֤
		infos[0] = this.validateFields(request);
		// ��ʼ����Ԫ��
		Map<String, Object> fieldsMap = new HashMap<String, Object>();
		if (infos[0].equals("true")) {
			fieldsMap = this.initFields(request);
		}
		// �ϴ�
		List<FileItem> fiList = (List<FileItem>) fieldsMap.get(UploadUtils.FILE_FIELDS);
		if (fiList != null) {
			for (FileItem item : fiList) {
				infos[1] = this.saveFile(item);
			}
			infos[2] = savePath;
			infos[3] = saveUrl;
			infos[4] = fileUrl;
		}
		return infos;
	}

	/**
	 * �ϴ���֤,����ʼ���ļ�Ŀ¼
	 * 
	 * @param request
	 */
	private String validateFields(HttpServletRequest request) {
		String errorInfo = "true";
		// boolean errorFlag = true;
		// ��ȡ��������
		String contentType = request.getContentType();
		int contentLength = request.getContentLength();
		// �ļ�����Ŀ¼·��
		savePath = request.getSession().getServletContext().getRealPath("/") + basePath + "/";
		// �ļ�����Ŀ¼URL
		saveUrl = request.getContextPath() + "/" + basePath + "/";
		File uploadDir = new File(savePath);
		if (contentType == null || !contentType.startsWith("multipart")) {
			// TODO
			System.out.println("���󲻰���multipart/form-data��");
			errorInfo = "���󲻰���multipart/form-data��";
		} else if (maxSize < contentLength) {
			// TODO
			System.out.println("�ϴ��ļ���С�����ļ�����С");
			errorInfo = "�ϴ��ļ���С�����ļ�����С[" + maxSize + "]";
		} else if (!ServletFileUpload.isMultipartContent(request)) {
			// TODO
			errorInfo = "��ѡ���ļ�";
		} else if (!uploadDir.isDirectory()) {// ���Ŀ¼
			// TODO
			errorInfo = "�ϴ�Ŀ¼[" + savePath + "]������";
		} else if (!uploadDir.canWrite()) {
			// TODO
			errorInfo = "�ϴ�Ŀ¼[" + savePath + "]û��дȨ��";
//		} else if (!extMap.containsKey(dirName)) {
//			// TODO
//			errorInfo = "Ŀ¼������ȷ";
		} else {
			// .../basePath/dirName/
			// �����ļ���
			savePath += dirName + "/";
			saveUrl += dirName + "/";
			File saveDirFile = new File(savePath);
			if (!saveDirFile.exists()) {
				saveDirFile.mkdirs();
			}
			// .../basePath/dirName/yyyyMMdd/
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String ymd = sdf.format(new Date());
			savePath += ymd + "/";
			saveUrl += ymd + "/";
			File dirFile = new File(savePath);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}

			// ��ȡ�ϴ���ʱ·��
			tempPath = request.getSession().getServletContext().getRealPath("/") + tempPath + "/";
			File file = new File(tempPath);
			if (!file.exists()) {
				file.mkdirs();
			}
		}

		return errorInfo;
	}

	/**
	 * �����ϴ�����
	 * 
	 * @param request
	 * @param maxSize
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
//	@SuppressWarnings("unchecked")
	private Map<String, Object> initFields(HttpServletRequest request)  {

		// �洢���ֶκͷǱ��ֶ�
		Map<String, Object> map = new HashMap<String, Object>();

		// ��һ�����ж�request
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		// �ڶ���������request
		if (isMultipart) {
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// ��ֵ,�������ֵ�Ż�д����ʱĿ¼,�������ڴ���
			factory.setSizeThreshold(1024 * 1024 * 10);
			factory.setRepository(new File(tempPath));

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			upload.setHeaderEncoding("UTF-8");

			// ����ϴ�����
			upload.setSizeMax(maxSize);

			/* FileItem */
			List<FileItem> items = null;
			// Parse the request
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// ��3��������uploaded items
			if (items != null && items.size() > 0) {
				Iterator<FileItem> iter = items.iterator();
				// �ļ������
				List<FileItem> list = new ArrayList<FileItem>();
				// ���ֶ�
				Map<String, String> fields = new HashMap<String, String>();
				while (iter.hasNext()) {
					FileItem item = iter.next();
					// �������б�Ԫ�غ��ļ����Ԫ��
					if (item.isFormField()) { // ��Ԫ��
						String name = item.getFieldName();
						String value = "";
						try {
							value = new String(item.getString().getBytes("ISO-8859-1"),"UTF-8");
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						fields.put(name, value);
					} else { // �ļ����Ԫ��
						list.add(item);
					}
				}
				formFields = fields;
				map.put(FORM_FIELDS, fields);
				map.put(FILE_FIELDS, list);
			}
		}
		return map;
	}

	/**
	 * �����ļ�
	 * 
	 * @param obj
	 *            Ҫ�ϴ����ļ���
	 * @param file
	 * @return
	 */
	private String saveFile(FileItem item) {
		String error = "true";
		String fileName = item.getName();
		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

		if (item.getSize() > maxSize) { // ����ļ���С
			// TODO
			error = "�ϴ��ļ���С��������";
//		} 
//		else if (!Arrays.<String> asList(extMap.get(dirName).split(",")).contains(fileExt)) {// �����չ��
//			
//			error = "�ϴ��ļ���չ���ǲ��������չ����\nֻ����" + extMap.get(dirName) + "��ʽ��";
		} else {
			String newFileName;
			if ("".equals(fileName.trim())) {
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
			} else {
				newFileName = fileName ;
				setFileName(fileName);
//				newFileName = fileName + "." + fileExt;
			}
			
			// .../basePath/dirName/yyyyMMdd/yyyyMMddHHmmss_xxx.xxx
			fileUrl = saveUrl + newFileName;
			// 
			finalUrl = savePath+newFileName;
			try {
				File uploadedFile = new File(savePath, newFileName);

				item.write(uploadedFile);

				/*
				 * FileOutputStream fos = new FileOutputStream(uploadFile); // �ļ�ȫ���ڴ��� if (item.isInMemory()) { fos.write(item.get()); } else { InputStream is = item.getInputStream(); byte[] buffer =
				 * new byte[1024]; int len; while ((len = is.read(buffer)) > 0) { fos.write(buffer, 0, len); } is.close(); } fos.close(); item.delete();
				 */
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("�ϴ�ʧ���ˣ�����");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return error;
	}

	/** **********************get/set����********************************* */

	public String getSavePath() {
		return savePath;
	}

	public String getSaveUrl() {
		return saveUrl;
	}

	public long getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(long maxSize) {
		this.maxSize = maxSize;
	}

	public Map<String, String> getExtMap() {
		return extMap;
	}

	public void setExtMap(Map<String, String> extMap) {
		this.extMap = extMap;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
		tempPath = basePath + TEMP_PATH;
	}

	public String getDirName() {
		return dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	public String getTempPath() {
		return tempPath;
	}

	public void setTempPath(String tempPath) {
		this.tempPath = tempPath;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Map<String, String> getFormFields() {
		return formFields;
	}

	public String getFinalUrl() {
		return finalUrl;
	}

	public void setFinalUrl(String finalUrl) {
		this.finalUrl = finalUrl;
	}
	
}
