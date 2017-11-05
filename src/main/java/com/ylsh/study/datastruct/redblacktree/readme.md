/** 新增节点后对红黑树的调整方法 */
 78     private void fixAfterInsertion(Entry<K,V> x) {
 79         // 将新插入节点的颜色设置为红色
 80         x. color = RED;
 81 
 82         // while循环，保证新插入节点x不是根节点或者新插入节点x的父节点不是红色（这两种情况不需要调整）
 83         while (x != null && x != root && x. parent.color == RED) {
 84             // 如果新插入节点x的父节点是祖父节点的左孩子
 85             if (parentOf(x) == leftOf(parentOf (parentOf(x)))) {
 86                 // 取得新插入节点x的叔叔节点
 87                 Entry<K,V> y = rightOf(parentOf (parentOf(x)));
 88                 // 如果新插入x的父节点是红色-------------------①
 89                 if (colorOf(y) == RED) {
 90                     // 将x的父节点设置为黑色
 91                     setColor(parentOf (x), BLACK);
 92                     // 将x的叔叔节点设置为黑色
 93                     setColor(y, BLACK);
 94                     // 将x的祖父节点设置为红色
 95                     setColor(parentOf (parentOf(x)), RED);
 96                     // 将x指向祖父节点，如果x的祖父节点的父节点是红色，按照上面的步奏继续循环
 97                     x = parentOf(parentOf (x));
 98                 } else {
 99                     // 如果新插入x的叔叔节点是黑色或缺少，且x的父节点是祖父节点的右孩子-------------------②
100                     if (x == rightOf( parentOf(x))) {
101                         // 左旋父节点
102                         x = parentOf(x);
103                         rotateLeft(x);
104                     }
105                     // 如果新插入x的叔叔节点是黑色或缺少，且x的父节点是祖父节点的左孩子-------------------③
106                     // 将x的父节点设置为黑色
107                     setColor(parentOf (x), BLACK);
108                     // 将x的祖父节点设置为红色
109                     setColor(parentOf (parentOf(x)), RED);
110                     // 右旋x的祖父节点
111                     rotateRight( parentOf(parentOf (x)));
112                 }
113             } else { // 如果新插入节点x的父节点是祖父节点的右孩子，下面的步奏和上面的相似，只不过左旋右旋的区分，不在细讲
114                 Entry<K,V> y = leftOf(parentOf (parentOf(x)));
115                 if (colorOf(y) == RED) {
116                     setColor(parentOf (x), BLACK);
117                     setColor(y, BLACK);
118                     setColor(parentOf (parentOf(x)), RED);
119                     x = parentOf(parentOf (x));
120                 } else {
						//新插入节点是左孩子，则 以 父节点进行 右旋
121                     if (x == leftOf( parentOf(x))) {
122                         x = parentOf(x);
123                         rotateRight(x);
124                     }
125                     setColor(parentOf (x), BLACK);
126                     setColor(parentOf (parentOf(x)), RED);
127                     rotateLeft( parentOf(parentOf (x)));
128                 }
129             }
130         }
131         // 最后将根节点设置为黑色，不管当前是不是红色，反正根节点必须是黑色
132         root.color = BLACK;
133     }
















 /**
 80      * 查找要删除节点的替代节点
 81      */
 82     static <K,V> TreeMap.Entry<K,V> successor(Entry<K,V> t) {
 83         if (t == null)
 84             return null;
 85         // 查找右子树的最左孩子
 86         else if (t.right != null) {
 87             Entry<K,V> p = t. right;
 
 			//如果只有一个右孩子，没有子节点。
 			如果有左孩子则找到。如果 右子树不存在
 88             while (p.left != null)
 89                 p = p. left;
 90             return p;
 91         } else { // 查找左子树的最右孩子
 92             Entry<K,V> p = t. parent;
 93             Entry<K,V> ch = t;
 94             while (p != null && ch == p. right) {
 95                 ch = p;
 96                 p = p. parent;
 97             }
 98             return p;
 99         }
 
 			
100     }