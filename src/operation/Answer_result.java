package operation;

class Node {
	//左右节点
	    public Node leftNode;
	    public Node rightNode;
	// 数据域
	    String text;  //String型符号节点
	    String value;//节点值
	    public Node(String text){
			this.text=text;
		} 
	}

public class Answer_result{
//创建根
	public Node root;
	public Answer_result(Node root) {this.root=root;}
	public Answer_result() {}
/**静态方法，读取算式的文本信息，逐个元素加入到树中，最后根据构建好的树进行四则运算		
 * 
 * @param exp
 * @return tree.count(tree.root);
 */
    		public static String countZ(String exp){
			Answer_result answer_result=new Answer_result();							
			Node pre=null;			
			int i=1;			
			StringBuilder numS=new StringBuilder();
			int flag=0;//标志位
			while(i<=exp.length()){
		    //截取一位字符串长度
				String s=exp.substring(i-1,i);
				if(isNum(s)){
				//判断截取这一位字符是数字
				//截取的是数字，截取相应部分的字符串，并标志为1，截取到最后一位直接入树
					numS.append(s);
					flag=1;
					if(i==exp.length()){
						//numS.toString; number--int  工厂模式建一个新Num(int,1)
						answer_result.addElement(numS.toString(),pre);																														
					}
				}
				
				//当前字符串不是数字
				else{
				    //上一个字符是数字，此字符是运算符
					if(flag==1){						
						Node node=answer_result.addElement(numS.toString(),pre);						
						Node nodeC=answer_result.addElement(s,node);
						pre=nodeC;
						flag=0;
						numS.delete(0,numS.length());
					}else{
					//上一个字符不是数字，直接加入树中
						Node nodeC=answer_result.addElement(s,pre);
						pre=nodeC;
					}
					
				}
				i++;
			}
			return String.valueOf(answer_result.count(answer_result.root));
			
		}
		
		/**
		 * isNum类：判断一个字符串是否是数字				
		 * @param s
		 * @return TRUE OR FALSE
		 */
			private static boolean isNum(String s){
					char[] a=s.toCharArray();
					for(int i=0;i<a.length;i++){
						if(a[i]<'0' ||a[i]>'9'){
							return false;
						}
					}
					return true;
				}
			/**
			 * addElement类:加入元素方法，可以加入数字字符串，符号字符串，ch是加入的字符串变量，preNode是上一个节点	
			 * @param ch
			 * @param preNode
			 * @return node
			 */
				public Node addElement(String ch,Node preNode){
						Node node=new Node(ch);
						//判定ch是否为数字
						  //1. ch为数字时
						if(isNum(ch)){				
							//1.1 ch为数字时，根节点为空，则node置入根节点
							if(root==null){					
								this.root=node;
							}
							//1.2 ch为数字时，根节点不为空，则node为上一个节点的右节点
							else{					
								preNode.rightNode=node;										
							}
						}
						//2. ch为运算符时
						  //2.1 ch为运算符，为+-运算，左节点为根节点的值，node为根节点
						else if(ch.equals("+")||ch.equals("-")){
							node.leftNode=this.root;
							this.root=node;
						}
						  //2.2 ch为运算符，为*/运算，左节点为根节点的值，node为根节点
						else if(ch.equals("*")||ch.equals("/")){
							//这里是成为上一个节点的父节点的操作，
							//由于子节点还没有提供方法指向父节点，所以这里采用了调换节点中存储的text方式来实现		
							node.text=preNode.text;
							preNode.text=ch;
							preNode.leftNode=node;
							return preNode;
						}
						return node;
					}	
				/**count类：递归的方式进行计算，和树的后序遍历方法一致	
				 * 	
				 * @param node
				 * @return Integer.parseInt(node.text)
				 */
						public int count(Node node){					
								if("+".equals(node.text)){
									return count(node.leftNode)+count(node.rightNode);

								}else if("-".equals(node.text)){
									return count(node.leftNode)-count(node.rightNode);
									
								}else if("*".equals(node.text)){
									return count(node.leftNode)*count(node.rightNode);
									
								}else if("/".equals(node.text)){
									return count(node.leftNode)/count(node.rightNode);				
								}else{
									
									return Integer.parseInt(node.text);
								}
						}		
		
		
}
