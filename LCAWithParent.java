package PureStorage;
/*
 * time:o(h); h worst-case could be o(n)
 * space:o(1)
 */
public class LCAWithParent {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
    	if(p==null||q==null){
    		return null;
    	}
    	int l=getHeight(root,p);
    	int r=getHeight(root,q);
    	if(l==-1||r==-1){
    		return null;
    	}
    	if(l>r){
    		return getCA(q,p,l-r);
    	}else{
    		return getCA(p,q,r-l);
    	}
    }
    public TreeNode getCA(TreeNode s,TreeNode l,int h){
    	while(h>0){
    		l=l.parent;
    		h--;
    	}
    	while(s!=null&&s!=l){
    		s=s.parent;
    		l=l.parent;
    	}
    	return s;
    }
    public int getHeight(TreeNode root,TreeNode p){
    	int h=0;
    	while(p!=null&&root!=p){
    		h++;
    		p=p.parent;
    	}
    	return root==p?h:-1;
    }
    public static void main(String[] args){
    	TreeNode a=new TreeNode(1);
    	TreeNode b=new TreeNode(2);
    	TreeNode c=new TreeNode(3);
    	TreeNode d=new TreeNode(4);
    	TreeNode e=new TreeNode(5);
    	TreeNode f=new TreeNode(6);
    	a.left=b;
    	a.right=f;
    	b.parent=a;
    	f.parent=a;
    	b.left=c;
    	b.right=d;
    	c.parent=b;
    	d.parent=b;
    	d.right=e;
    	e.parent=d;	
    	LCAWithParent lc=new LCAWithParent();
    	System.out.println(lc.lowestCommonAncestor(a, c, f).val);
    }	
}





class TreeNode{
	int val;
	TreeNode parent;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val=val;
		parent=null;
		left=null;
		right=null;	
	}
}
