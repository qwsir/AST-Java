package com.parse.dao;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class TypeDeclarationVisit extends ASTVisitor {
	public MethodDeclaration[] method;
	public FieldDeclaration[] fieldlist;
	public List<ASTNode> superinterfacetypes=new ArrayList<ASTNode>();
	public ASTNode typename;
	public List<MethodDeclaration> methodlist=new ArrayList<MethodDeclaration>();
	public List<Modifier> modifier=new ArrayList<Modifier>();
	public List<TypeDeclaration> typedeclarationnode=new ArrayList<TypeDeclaration>();
	public boolean isinterface;
	public Type superclasstype;
	public Javadoc javadoc;
		
	@Override
	public boolean visit(TypeDeclaration node) {
		//typedeclarationnode.add(node);
		method=node.getMethods();
		javadoc=node.getJavadoc();
		fieldlist=node.getFields();
		typename=node.getParent();
		isinterface=node.isInterface();
		//获得当前类中的方法放到方法数组中。并添加到方法集合中
		MethodDeclaration meth[]=node.getMethods();
		for(MethodDeclaration item1:method)
		{methodlist.add(item1);}
		for (Object item : node.modifiers())
		{
			if (item.toString().charAt(0) != '@')
				modifier.add((Modifier) item);
		}
		superinterfacetypes=node.superInterfaceTypes();
        superclasstype=node.getSuperclassType();
		TypeDeclaration[] typed=node.getTypes();
		for(TypeDeclaration item2: typed) {
			typedeclarationnode.add(item2);
			
		}
		
	//	System.out.println("<TypeDeclaration>");
		System.out.println("<Javadoc>");
		if(javadoc!=null)
	    System.out.print(javadoc.toString());
		else System.out.println("null");
	    System.out.println("</Javadoc>");
		System.out.print("<Modifier>");
		for (Modifier item : modifier) {
			System.out.print(item.getKeyword() + "");
		}
		System.out.println("</Modifier>");
		System.out.println("<Interface>"+isinterface+"</Interface>");
		System.out.println("<ClassName>" + node.getName().toString()+ "</ClassName>");
		System.out.println("<SuperClassType>"+superclasstype+"</SuperClassType>");
		System.out.print("<SuperInterfaces>");
		for (ASTNode item : superinterfacetypes) {
			System.out.println(item.toString());
		}
		System.out.println("</SuperInterfaces>");	
		// TODO Auto-generated method stub
		return super.visit(node);
	}

}
