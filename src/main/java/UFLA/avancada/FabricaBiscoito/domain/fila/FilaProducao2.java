package UFLA.avancada.FabricaBiscoito.domain.fila;

import UFLA.avancada.FabricaBiscoito.domain.biscoito.Biscoito;
import UFLA.avancada.FabricaBiscoito.domain.forno.Forno1;
import UFLA.avancada.FabricaBiscoito.domain.forno.Forno2;
import UFLA.avancada.FabricaBiscoito.domain.linha.*;

import java.util.List;
import java.util.Vector;

public class FilaProducao2 implements Runnable, Fila {
    private List<Biscoito> biscoitoLista = new Vector<Biscoito>();
    private LinhaProducao2 linhaProducao;
    private LinhaProducao2b linhaProducaob;
    private LinhaProducao2c linhaProducaoc;
    private Forno1 forno1;
    private Forno2 forno2;

    private int tamanho = 0;

    public FilaProducao2(LinhaProducao2 linhaProducao, LinhaProducao2b linhaProducaob, LinhaProducao2c linhaProducaoc, Forno1 forno1, Forno2 forno2 ) {
        this.linhaProducao = linhaProducao;
        this.linhaProducaob = linhaProducaob;
        this.linhaProducaoc = linhaProducaoc;
        this.forno1 = forno1;
        this.forno2 = forno2;
    }

    @Override
    public void run() {
        synchronized (this.linhaProducao) {
            System.out.println("procesando biscoito linha de produção 1");
            linhaProducao.montar();
        }

        synchronized (this.linhaProducaob) {
            linhaProducaob.montar();
        }

        synchronized (this.linhaProducaoc) {
            linhaProducaoc.montar();
        }

        if(!forno1.getOcupado()) {
            synchronized (this.forno1) {
                System.out.println("Assando biscoito forno 1");
                forno1.assar(biscoitoLista.remove(0));
                biscoitoPronto();
            }
        } else {
            synchronized (this.forno2) {
                System.out.println("Assando biscoito forno 2");
                forno2.assar(biscoitoLista.remove(0));
                biscoitoPronto();
            }
        }
    }

    @Override
    public List<Biscoito> getBiscoitoLista(){
        return this.biscoitoLista;
    }
    @Override
    public int getBiscoitoListaSize() {
        return this.biscoitoLista.size();
    }

    @Override
    public boolean getPermiteRecheado() {
        return true;
    }

    @Override
    public void adicionaBiscoito(Biscoito biscoito) {
        this.biscoitoLista.add(biscoito);
        this.tamanho++;
    }

    @Override
    public Linha getLinha() {
        return this.linhaProducao;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void biscoitoPronto() {
        this.tamanho--;
    }
}
