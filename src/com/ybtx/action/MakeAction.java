package com.ybtx.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.javafx.collections.MappingChange.Map;
import com.ybtx.domain.Make;
import com.ybtx.service.EmployeeService;
import com.ybtx.service.MakeService;
import com.ybtx.service.ProductService;
import com.ybtx.vo.MakePage;

public class MakeAction extends ActionSupport implements ModelDriven<Make>{
	//ģ������
	private Make make = new Make();
	//spring�е���service
	private MakeService makeService;
	private EmployeeService employeeService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	private ProductService productService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public void setMakeService(MakeService makeService) {
		this.makeService = makeService;
	}
	//��ҳ��ģ
	private int currentPage = 1;
	private int pageSize = 10;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	public Make getMake() {
		return make;
	}
	public void setMake(Make make) {
		this.make = make;
	}
	
	//�����ݿ����������¼
	public String add() {
		//������¼�У�Employee��Product��������󣬲���ֱ�Ӵ�ҳ�����õ�
		//��ҳ����Ի�õ�Employee��Product�����ID
		//�ٵ���findById����
		make.setEmployee(employeeService.findById(make.getEmployeeId()));
		make.setProduct(productService.findById(make.getProductId()));
		makeService.add(make);
		return SUCCESS;	
	}
	//�������ݿ��е���������
	public String findAll() {
		MakePage makePage = makeService.findAll(currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("makePage", makePage);
		return SUCCESS;
	}
	//����id��ѯ������¼
	public String fingById() {
		MakePage makePage = makeService.findById(make.getMakeId(),currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("makePage", makePage);
		return SUCCESS;		
	}
	//��ѯָ��ʱ������棬ÿ�����˵Ĺ��ʣ�ÿ��������¼�Ĺ���֮�� group by employee��
	public String searchEmployeeWage(){
		String sql = "SELECT employee.employeeName,SUM(makeAmount * productWage) ���� " + 
				"FROM make,product,employee " + 
				"WHERE make.makeProduct = product.productId " + 
				"	AND make.makeEmployee = employee.employeeId " + 
				"	AND make.makeDate > '" + make.getStartDate() +
				"'	AND make.makeDate < '" + make.getEndDate() +
				"' GROUP BY employee.employeeName"+
				" ORDER BY ���� DESC"; 
		System.out.println(sql);
        List<Object[]> list = makeService.queryBySql(sql);    
        System.out.println("---"+list.size());
        double totalWage = 0;
        for(Object[] obj :list)    
        {    
            System.out.println(obj[0]+" -- "+ obj[1]);
            totalWage = totalWage + (double)obj[1];
        }
        ServletActionContext.getRequest().setAttribute("EmployeeWageList", list);
        ServletActionContext.getRequest().setAttribute("totalWage",totalWage);
		return "EmployeeWageList";
	}
	
	//����ͳ��ĳ�����˵Ĺ���
	public String employeeWageByDay() {
		String sql = "SELECT SUM(make.makeAmount * productWage),DAY(make.makeDate) day " + 
				"FROM make,product,employee " + 
				"WHERE make.makeProduct = product.productId " + 
				"	AND make.makeEmployee = employee.employeeId " + 
				"	AND make.makeEmployee = 1 " + 
				"	AND MONTH(make.makeDate)=7 " + 
				"GROUP BY make.makeDate " + 
				"ORDER BY make.makeDate";
		System.out.println(sql);
		
        List<Object[]> list = makeService.queryBySql(sql); 
        List<HashMap<String, Double>> map_List = new ArrayList<HashMap<String, Double>>();
        
        
        System.out.println("---"+list.size());
        for(Object[] obj :list)    
        {    
            System.out.println(obj[0]+" -- "+ obj[1]);
            HashMap<String,Double> map = new HashMap();
            Integer day = (Integer) obj[1];
            map.put("date", day.doubleValue());
            map.put("wage", (Double) obj[0]);
            map_List.add(map);
        }
   	 	String result = JSON.toJSONString(map_List);
   	 	System.out.println("JSON"+result);
        ServletActionContext.getRequest().setAttribute("employeeWageByDay", result);
		return "EmployeeWageByDay";
	}
	
	@Override
	public Make getModel() {
		return make;
	}
	
}
