package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(){

    class RedBlackTreeNode{
        constructor(value){
            this.value = value;
            this.color = "RED";
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    class RedBlackTree{
        constructor(){
            this.root = null;
        }

        add(value){
            const newNode = new RedBlackTreeNode(value);

            if (this.root === null){
                this.root = newNode;
                this.root.color = "BLACK";
            } else{
                this.addNode(this.root, newNode);
                this.balance(newNode);
            }
        }

        addNode(node, newNode){
            if (newNode.value < node.value){
                if (node.left == null){
                    node.left=newNode;
                    newNode.parent=node;
                } else{
                    this.addNode(node.left, newNode);
                }
            } else{
                if(node.right === null){
                    node.right = newNode;
                    newNode.parent = node;
                } else{
                    if (node.right === null){
                        node.right = newNode;
                        newNode.parent = node;
                    } else{
                        this.addNode(node.right, newNode);
                    }
                }
            }
            balance(node){
                while (node.parent !== null && node.parent.color === "RED"){
                    if (node.parent === node.parent.parent.left){
                        const uncle = node.parent.parent.right;

                        if (uncle !== null && uncle.color === "RED"){
                            node.parent.color = "BLACK";
                            uncle.color = "BLACK";
                            node.parent.parent.color = "RED";
                            node = node.parent.parent;
                        } else {
                            if (node === node.parent.right){

                                node = node.parent;
                                this.rotateLeft(node);
                            }

                            node.parent.color = "BLACK";
                            node.parent.parent.color = "RED";
                            this.rotateRight(node.parent.parent);
                        }
                    } else{
                        const uncle = node.parent.parent.left;

                        if(uncle !== null && uncle.color === "RED"){
                            node.parent.color = "BLACK";
                            uncle.color = "BLACK";
                            node.parent.parent.color = "RED";
                            node = node.parent.parent;
                        } else{
                            if(node === node.parent.left){
                                node = node.parent;
                                this.rotateRight(node);
                            }

                            node.parent.color = "BLACK";
                            node.parent.parent.color = "RED";
                            this.rotateLeft(node.parent.parent);
                        }
                    }
                }
                this.root.color = "BLACK";
            }

            rotateLeft(node){
                const temp = node.right;
                node.right = temp.left;

                if (temp.left !== null){
                    temp.left.parent = node;
                }

                temp. parent = node.parent;

                if (node.parent === null){
                    this.root = temp;
                } else if (node === node.parent.left){
                    node.parent.left = temp;
                } else{
                    node.parent.right = temp;
                }

                temp.left = node;
                node.parent = temp;
            }

            rotateRight(node){
                const temp = node.left;
                node.left = temp.right;

                if (temp.right !== null){
                    temp.right.parent = node;
                }

                temp.parent = node.parent;
                if(node.parent === null){
                    this.root = temp;
                } else if (node === node.parent.left){
                    node.parent.left = temp;
                } else {
                    node.parent.right = temp;
                }
                temp.right = node;
                node.parent = temp;
            }
        }
    }
}
}