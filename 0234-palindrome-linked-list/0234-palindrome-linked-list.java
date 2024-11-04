class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> pila = new Stack<>();
        ListNode aux = head;
        ListNode medio = head;

        // Paso #2 (Step #2)
        while (aux != null && aux.next != null) {
            pila.push(medio.val);
            medio = medio.next;
            aux = aux.next.next;
        }

        // Paso #3 (Step #3)
        if (aux != null) medio = medio.next;

        // Paso #4 (Step #4)
        while (!pila.isEmpty()) {
            int tope = pila.pop();
            if (medio.val != tope) return false;
            medio = medio.next;
        }
        return true;

    }
}