package com.ybtx.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
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
		String start =  make.getStartDate();
		String end = make.getEndDate();
		String sql = "SELECT employee.employeeName,SUM(makeAmount * productWage) ���� " + 
				"FROM make,product,employee " + 
				"WHERE make.makeProduct = product.productId " + 
				"	AND make.makeEmployee = employee.employeeId " + 
				"	AND make.makeDate > '" + start +
				"'	AND make.makeDate < '" + end +
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
	
	@Override
	public Make getModel() {
		return make;
	}
	
}
