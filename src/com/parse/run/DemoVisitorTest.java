package com.parse.run;


import java.io.FileNotFoundException;
import java.io.PrintStream;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import com.parse.util.JdtAstUtil;
import com.parse.dao.*;


/**
 * @author Leslie
 *
 */
public class DemoVisitorTest {

	public static void main(String[] args) {
		
		//输入需要进行解析的java文件
		CompilationUnit comp = JdtAstUtil.getCompilationunit("src//com//parse//run//test.java");
		//JavaAST.xml为解析后的xml文件
		try {
		PrintStream out = System.out;                      //缓存系统默认的打印输出流
		PrintStream ps=new PrintStream("JavaAST.xml");	   // 创建一个打印输出流
		System.setOut(ps);                                  //将创建的打印输出流赋给系统
		System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		System.out.println("<CompilationUnit>");
	
		HeadVisitor hv = new HeadVisitor();           	  // 实现CompilationUnit类节点的属性输出
		comp.accept(hv);
		
     	for(TypeDeclaration itemss:hv.type) {             //实现TypeDeclaration类节点的输出
			System.out.println("<TypeDeclaration>");
			TypeDeclarationVisit tt = new TypeDeclarationVisit();
			itemss.accept(tt);	

		for (MethodDeclaration item : tt.methodlist) {      // 实现MethodDeclaration类节点的属性输出
			System.out.println("<Method>");
			MethodDeclarationVisit mv = new MethodDeclarationVisit();
			item.accept(mv);
			System.out.print("<Statements>");
	
			for (Statement item2 : mv.statement) {             	//实现方法中Statement类节点的属性输出
				StatementVisitor av = new StatementVisitor();
				item2.accept(av);
			}
			System.out.println("</Statements>");
			System.out.println("</Method>");
		}	
		System.out.println("</TypeDeclaration>");
		}		
		System.out.println("</CompilationUnit>");
			     System.setOut(out);                          //将缓存的打印输出流重新设置给系统。
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
