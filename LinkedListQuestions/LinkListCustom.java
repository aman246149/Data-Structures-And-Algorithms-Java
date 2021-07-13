
import java.util.List;

public class LinkListCustom {
    ListNode head;
    static class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }

    public void insertNodeAtStart(int data){
        ListNode newnode=new ListNode(data);
        if (head==null){
            head=newnode;
        }else{
            newnode.next=head;
            head=newnode;
        }
    }

    public void insertNodeAtEnd(int data){
        ListNode newnode=new ListNode(data);

        if (head==null){  //if no node is present
            head=newnode;
        }else{
            // if more than 1 node is present
            ListNode temp=head;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=newnode;

        }
    }

    public void findLengthOfLinkedList(){
        ListNode temp=head;
        int count=0;
        while (temp!=null){
            temp=temp.next;
            count++;
        }
        System.out.println( "Length OF Linked List "+count);
    }

    public void deletefirstNode(){
        if (head==null){
            System.out.println("oopps no node is present");
        }
        else{
            ListNode temp=head;
            System.out.println("deleted node is"+ temp.data);
            head=head.next;
            temp.next=null;

        }
    }

    public void deletefromlast(){
        if (head==null){
            System.out.println("oopps no node is present");
        }else{
            ListNode temp=head;
            ListNode previous=null;
            while(temp.next.next!=null){
//                previous=temp;
                temp=temp.next;
            }
            temp.next=null;
        }
    }

    public void searchInLinkList(int key){
        ListNode temp=head;
        while (temp!=null){
            if (temp.data==key){
                System.out.println("element present in LinkList");
            }else{
                System.out.println("element is not present");
            }
            temp=temp.next;
        }
    }

    public  ListNode delete_node( int key)
    {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            if (current.data == key) {
                if(current == head){
                    head = head.next;
                    current = head;
                }
                else{
                    prev.next = current.next;
                    current = current.next;
                }
            }
            else {
                prev = current;
                current = current.next;
            }
        }

        return head;
    }

    public void deletefromSpecificPosition(int position){
            ListNode previous=null;
            ListNode current=head;
            int count=0;
        if(position == 0){
            ListNode temp = head;
            head = head.next;
            temp.next = null;
        }else{
            while (count!=position){
                previous=current;
                current=current.next;
                count++;
            }
            previous.next=current.next;
        }



    }


    public void arrangeOddEven(){
        ListNode odh=head;
        ListNode odt=head;

        ListNode evh=odh.next;
        ListNode evt=odh.next;
        ListNode temp=evh.next;

        odh.next=evh.next=null;


        while (temp!=null){
            odt.next=temp;
            odt=temp;
            temp=temp.next;
            odt.next=null;

            evt.next=temp;
            evt=temp;
            temp=temp.next;
            evt.next=null;

        }
        odt.next=evh;

    }

    

    //TODO//remove k th element from end


    //todo swap nodes in pair

    ListNode function(ListNode head){
        if (head==null || head.next==null){
            return head;
        }

        ListNode newhead=function(head.next.next);
        ListNode temp=head.next;
        temp.next=head;
        head.next=newhead;
        return temp;
    }



    static int length(ListNode head){
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }     
        
        return count;
     }
     
     //INTERSECTION POINT OF TWO LINKLIST

    static int findMergeNode(ListNode head1, ListNode head2) {
        
        int l1=length(head1);
        int l2=length(head2);
        
        int d=0;
        ListNode ptr1;
        ListNode ptr2;
        
        if(l1>l2){
            d=l1-l2;
            ptr1=head1;
            ptr2=head2;
        }else{
            d=l2-l1;
            ptr1=head2;
            ptr2=head1;
        }
        
        while(d!=0){
            ptr1=ptr1.next;
            if(ptr1==null){
                return -1;
            }
            d--;
            
        }
        
        while(ptr1!=null && ptr2!=null){
            if(ptr1==ptr2){
                return ptr1.data;
            }
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        
        return -1;

    }

    public ListNode reverseALinkList(ListNode head){

        ListNode current=head;
        ListNode prev=null;
        ListNode front=null;

        while(current!=null){
            front=current.next;
            current.next=prev;
            prev=current;
            current=front;
        }

        return prev;

    }

    public void displayNode(){
        ListNode temp=head;
        while (temp!=null){
            System.out.print(temp.data+" "+ "=> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    
    public static void main(String[] args) {
        LinkListCustom ll=new LinkListCustom();
       ll.insertNodeAtStart(20);
       ll.insertNodeAtStart(40);
       ll.insertNodeAtEnd(50);
       ll.insertNodeAtEnd(60);
       ll.insertNodeAtEnd(99);
       ll.insertNodeAtEnd(536);
//        ll.insertNodeAtEnd(123456);
        ll.insertNodeAtEnd(1);
        ll.insertNodeAtEnd(2);
        ll.insertNodeAtEnd(3);
        ll.insertNodeAtEnd(4);
        // ll.function(ll.head);
//        ll.arrangeOddEven();
        ll.displayNode();
//        ll.delete_node(20);
//        ll.findLengthOfLinkedList();
//        ll.deletefirstNode();
//        ll.deletefromlast();
//        ll.searchInLinkList(123456);
//        ListNode lls= ll.delete_node(99);
//        ll.deletefromSpecificPosition(2);
//        ll.displayNode();
            ll.reverseALinkList(ll.head);
            ll.displayNode();
    }
}
