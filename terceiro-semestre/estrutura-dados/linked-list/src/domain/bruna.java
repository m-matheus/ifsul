public void orderByAsc() {
    if (isEmpty() || head.getProximo() == null) {
        return; // Lista vazia ou com apenas um elemento nao precisa ordenar
    }

    No atual = head.getProximo();
    No anterior;
    No temp;

    while (atual != null) {
        No proximoNo = atual.getProximo();
        anterior = null;
        temp = head;

        while (temp != atual && temp.getDado() < atual.getDado()) {
            anterior = temp;
            temp = temp.getProximo();
        }sei 

        if (temp != atual) {
            if (anterior != null) {
                anterior.setProximo(atual.getProximo());
            } else {
                head.setProximo(atual.getProximo());
            }

            if (temp == head) {
                atual.setProximo(head);
                head = atual;
            } else {
                anterior = head;
                while (anterior.getProximo() != temp) {
                    anterior = anterior.getProximo();
                }
                anterior.setProximo(atual);
                atual.setProximo(temp);
            }
        }

        atual = proximoNo;
    }