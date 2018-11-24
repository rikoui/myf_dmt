package com.bjdreamtech.dmt.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 返回菜单bean，用于封装加载菜单返回的json数据
 * @author duanwu
 *
 */
public class DMTMenuBean {
	
	//菜单集合
	private List<Menus> menus;
	
	public List<Menus> getMenus() {
		return menus;
	}

	public void setMenus(List<Menus> menus) {
		this.menus = menus;
	}
	
	/**
	 * 将从数据库查询出来的菜单集合转换成菜单bean对象
	 * @param menulist
	 * @return
	 */
	public void parseList(List<Map<String,String>> menuList){
		//菜单bean对象中的一级菜单集合数据
		menus = new ArrayList<Menus>();
		//循环数据库查询数据集合，将一级菜单初始化到返回对象中
		for(Map<String,String> menuMap : menuList){
			//获取菜单的级别
			String level = menuMap.get("level");
			//如果菜单为一级菜单
			if("1".equals(level)){
				//初始化一级菜单数据
				Menus menu  = new Menus();
				menu.setMenuid(menuMap.get("id"));
				menu.setMenuname(menuMap.get("name"));
				menus.add(menu);
			}
		}
		
		//循环一级菜单集合，初始化一级菜单中的二级菜单数据
		for(int i=0;i<menus.size();i++){
			//菜单bean对象中的一级菜单中的二级菜单集合
			List<ChildMenus> cmList = new ArrayList<ChildMenus>();
			//从参数传递的数据集合中查找二级菜单
			for(Map<String,String> menuMap : menuList){
				//获取菜单的父菜单ID
				String parentid = menuMap.get("parentid");
				//如果此菜单属于循环中的一级菜单的子菜单
				if(parentid!=null&&parentid.equals(menus.get(i).getMenuid())){
					//将此菜单初始化到二级菜单集合中
					ChildMenus cm  = new ChildMenus();
					cm.setMenuname(menuMap.get("name"));
					cm.setUrl(menuMap.get("path"));
					cm.setMenuid(menuMap.get("id"));
					cmList.add(cm);
				}
			}
			//设置二级菜单数据集合
			menus.get(i).setMenus(cmList);
		}
	}

	/**
	 * 内部一级菜单类
	 * @author duanwu
	 *
	 */
	class Menus {
		//菜单主键
		private String menuid;
		//菜单图标，默认icon-sys
		private String icon = "icon-sys";
		//一级菜单名
		private String menuname;
		//二级菜单集合
		private List<ChildMenus> menus;
		
		public String getMenuid() {
			return menuid;
		}
		public void setMenuid(String menuid) {
			this.menuid = menuid;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public String getMenuname() {
			return menuname;
		}
		public void setMenuname(String menuname) {
			this.menuname = menuname;
		}
		public List<ChildMenus> getMenus() {
			return menus;
		}
		public void setMenus(List<ChildMenus> menus) {
			this.menus = menus;
		}
		
		
	}
	
	/**
	 * 内部二级菜单类
	 * @author duanwu
	 *
	 */
	class ChildMenus {
		//二级菜单名称
		private String menuname;
		//二级菜单url
		private String url;
		//二级菜单id
		private String menuid;
		
		public String getMenuname() {
			return menuname;
		}
		public void setMenuname(String menuname) {
			this.menuname = menuname;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getMenuid(){
			return menuid;
		}
		public void setMenuid(String menuid){
			this.menuid = menuid;
		}
		
		
	}
	
	
}
