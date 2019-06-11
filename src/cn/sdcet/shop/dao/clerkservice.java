package cn.sdcet.shop.dao;

import java.util.List;

import cn.sdcet.shop.domain.clerkbean;





public interface clerkservice {
	public List<clerkbean> findall();
	public void insertnew(clerkbean c);
	public void update(clerkbean c);

	public List<clerkbean> findby(clerkbean c);
	public clerkbean findbyid(String id);
	public boolean addcheck(String id);
}
