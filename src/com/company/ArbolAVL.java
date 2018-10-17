package com.company;

public class ArbolAVL<AnyType extends Comparable<AnyType>> {
    private NodoArbol<AnyType> raiz;


    public void insertar(AnyType d) throws Exception {
        raiz = insertar(d, raiz);
    }

    public AnyType buscar(AnyType d) throws Exception {
        return buscar(d, raiz);
    }

    public void borrar(AnyType d) throws Exception {
        borrar(d, raiz);
    }

    public void inOrder() {
        inOrder(raiz);
    }

    public void preOrder() {
        preOrder(raiz);
    }

    public void postOrder() {
        postOrder(raiz);
    }

    public void print() {
        print(false, "", raiz);
    }

    private NodoArbol<AnyType> insertar(AnyType d, NodoArbol<AnyType> r) throws Exception {
        if (r == null)
            return new NodoArbol<>(d);

        if (d.compareTo(r.getDato()) > 0) {
            r.setDer(insertar(d, r.getDer()));
        } else if (d.compareTo(r.getDato()) < 0) {
            r.setIzq(insertar(d, r.getIzq()));
        }

        balanceo(r);

        // RSI (rotación simple Izquierda)
        if (r.getBalanceo() > 1 && r.getDer().getBalanceo() > 0)
            return rotacionIzq(r);

        // RSD
        if (r.getBalanceo() < -1 && r.getIzq().getBalanceo() < 0)
            return rotacionDer(r);

        // RDI
        if (r.getBalanceo() < -1 && r.getIzq().getBalanceo() > 0) {
            r.setIzq(rotacionIzq(r.getIzq()));
            return rotacionDer(r);
        }
        // RDD
        if (r.getBalanceo() > 1 && r.getDer().getBalanceo() < 0) {
            r.setDer(rotacionDer(r.getDer()));
            return rotacionIzq(r);
        }

        return r;
    }

    private void balanceo(NodoArbol<AnyType> r) {
        int aDer = altura(r.getDer());
        int aIzq = altura(r.getIzq());

        r.setBalanceo(aDer - aIzq);
    }

    private NodoArbol<AnyType> rotacionIzq(NodoArbol<AnyType> r) {
        NodoArbol<AnyType> der = r.getDer();
        der.setIzq(r);
        r.setDer(null);

        balanceo(r);
        balanceo(der);

        return der;

    }

    private NodoArbol<AnyType> rotacionDer(NodoArbol<AnyType> r) {
        NodoArbol<AnyType> izq = r.getIzq();
        izq.setDer(r);
        r.setIzq(null);

        balanceo(r);
        balanceo(izq);

        return izq;
    }


    private AnyType buscar(AnyType d, NodoArbol<AnyType> r) throws Exception {

        if (r == null)
            throw new Exception("404");

        int comp = d.compareTo(r.getDato());
        if (comp == 0)
            return r.getDato();

        if (comp > 0)
            return buscar(d, r.getDer());
        else
            return buscar(d, r.getIzq());
    }

    private NodoArbol<AnyType> borrar(AnyType d, NodoArbol<AnyType> r) throws Exception {
        if (r == null)
            throw new Exception("404");

        int comp = d.compareTo(r.getDato());
        if (comp == 0) {
            insertar(r.getDer(), r.getIzq());
            return r.getDer();
        }

        if (comp > 0) {
            r.setDer(borrar(d, r.getDer()));
            return r;
        } else {
            r.setIzq(borrar(d, r.getIzq()));
            return r;
        }
    }


    private void insertar(NodoArbol<AnyType> r, NodoArbol<AnyType> h) throws Exception {

        int comp = r.getDato().compareTo(h.getDato());

        if (comp > 0) {
            if (r.getDer() != null) {
                insertar(r.getDer(), h);
            } else {
                r.setDer(h);
            }
            return;
        }


        if (comp < 0) {
            if (h.getIzq() != null) {
                insertar(r.getIzq(), h);
            } else {
                r.setIzq(h);
            }
            return;
        }
        throw new Exception("El nodo ya existe");
    }
//
//    public int altura() {
//        return altura(raiz);
//    }
//
//    public int profundidad(AnyType d) {
//        return profundidad(d, raiz);
//    }


    private void inOrder(NodoArbol<AnyType> r) {

        if (r == null)
            return;

        inOrder(r.getIzq());
        System.out.println(r.getDato());
        inOrder(r.getDer());

        /*

        if (r.getIzq() != null)
            inOrder(r.getIzq());

        System.out.println(r.getDato());

        if (r.getDer() != null)
            inOrder(r.getDer());

        */
    }


    private void preOrder(NodoArbol r) {
        if (r == null)
            return;

        System.out.println(r.getDato());
        preOrder(r.getIzq());
        preOrder(r.getDer());
    }


    private void postOrder(NodoArbol r) {
        if (r == null)
            return;

        preOrder(r.getIzq());
        preOrder(r.getDer());
        System.out.println(r.getDato());
    }


    private void print(boolean esDerecho, String identacion, NodoArbol<AnyType> r) {
        if (r.getDer() != null) {
            print(true, identacion + (esDerecho ? "     " : "|    "), r.getDer());
        }
        System.out.print(identacion);
        if (esDerecho) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("-- ");
        System.out.println(r.getDato() + "|" + r.getBalanceo());
        if (r.getIzq() != null) {
            print(false, identacion + (esDerecho ? "|    " : "     "), r.getIzq());
        }
    }

    private int altura(NodoArbol r) {
        if (r == null)
            return 0;

        int ai = altura(r.getIzq());
        int ad = altura(r.getDer());

        if (ai > ad) {
            return ai + 1;
        } else
            return ad + 1;
    }


}


/*
https://github.com/IUA-Informatica3/Estructuras
http://lain.marku.me/
 */
