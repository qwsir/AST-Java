package com.parse.dao;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.Type;

public class MethodDeclarationVisit extends ASTVisitor {
	public List<Modifier>  modifier=new ArrayList<Modifier>();
	public Type  returntype;
	public String name;
	public boolean isconstructor;
	public List<SingleVariableDeclaration> parameters =new ArrayList<SingleVariableDeclaration>();
	public List<Statement> statement=new ArrayList<Statement>();
	
	
	
	@Override
	public boolean visit(MethodDeclaration node) {
		modifier=node.modifiers();
		returntype=node.getReturnType2();
		isconstructor=node.isConstructor();
		name=node.getName().toString();
		parameters=node.parameters();
		statement=node.getBody().statements();
		// TODO Auto-generated method stub
	//	System.out.println("<Method>");
		System.out.print("<Modifiers>");
		for (Modifier item2 : modifier) {
			System.out.print(item2.toString() + " ");
		}
		System.out.println("</Modifiers>");
		System.out.println("<IsConstructor>" + isconstructor + "</IsConstructor>");
		System.out.println("<ReturnType>" + returntype + "</ReturnType>");	
		System.out.println("<MethodName>" + name + "</MethodName>");
		System.out.print("<Parameters>");
		for (ASTNode item2 : parameters) {
			System.out.print(item2.toString()+ " ");
		}
		System.out.println("</Parameters>");
		return super.visit(node);
	}

}
