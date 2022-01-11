//Remove Kth Node from End

//Same Algo :)
//2 Pointers, fast and slow
//Move fast k steps
//Move both till fast->next!=NULL
//Then slow will be at prev of kth node
//So Simply remove slow->next=slow->next->next;
//Delete That Node by temp
//delete temp;


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(head==NULL)
            return head;
        int s=len(head);
        if(s==1 and n!=0){
            return NULL;
        }
        if(n==s)
        {
            removeFromHead(head);
            return head;
        }
        ListNode* fast=head;
        ListNode* slow=head;
        int k=n;
        while(k--)
        {
            fast=fast->next;
        }
        if(fast==NULL)
            return head->next;
        if(fast==NULL)
        {
            return head->next;
        }
        while(fast->next!=NULL)
        {
            fast=fast->next;
            slow=slow->next;
        }
        ListNode* temp=slow->next;
        slow->next=slow->next->next;
        delete temp;
        return head;
    }
    void removeFromHead(ListNode*&head)
    {
        head=head->next;
    }
    int len(ListNode* head)
    {
        if(head==NULL)
            return 0;
        int size=0;
        while(head!=NULL)
        {
            head=head->next;
            size++;
        }
        return size;
    }
};
