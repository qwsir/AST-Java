package com.parse.dao;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class HeadVisitor extends ASTVisitor {
	public PackageDeclaration packageNode;
	public List<ImportDeclaration> importList=new ArrayList<ImportDeclaration>(); 
	public List<TypeDeclaration> type=new ArrayList<TypeDeclaration>();
	
	public boolean visit(CompilationUnit node)
	{
		type=node.types();
		packageNode=node.getPackage();
		importList=node.imports();
		System.out.println("<Package>" + packageNode.getName().toString() + "</Package>");
		for (ImportDeclaration it : importList) {
			System.out.println("<Import>" + it.getName().toString() + "</Import>");
		}
		return false;
	}
}
