package Assign1;

public class BST
    { private BTNode<Integer> root;

        public BST()
        { root = null;
        }

        public boolean find(Integer i)
        { BTNode<Integer> n = root;
            boolean found = false;

            while (n!=null && !found)
            { int comp = i.compareTo(n.data);
                if (comp==0)
                    found = true;
                else if (comp<0)
                    n = n.left;
                else
                    n = n.right;
            }

            return found;
        }

        public boolean insert(Integer i)
        { BTNode<Integer> parent = root, child = root;
            boolean goneLeft = false;

            while (child!=null && i.compareTo(child.data)!=0)
            { parent = child;
                if (i.compareTo(child.data)<0)
                { child = child.left;
                    goneLeft = true;
                }
                else
                { child = child.right;
                    goneLeft = false;
                }
            }

            if (child!=null)
                return false;  // number already present
            else
            { BTNode<Integer> leaf = new BTNode<Integer>(i);
                if (parent==null) // tree was empty
                    root = leaf;
                else if (goneLeft)
                    parent.left = leaf;
                else
                    parent.right = leaf;
                return true;
            }
        }
    }

    class BTNode<T>
    { T data;
        BTNode<T> left, right;

        BTNode(T o)
        { data = o; left = right = null;
        }
    }
