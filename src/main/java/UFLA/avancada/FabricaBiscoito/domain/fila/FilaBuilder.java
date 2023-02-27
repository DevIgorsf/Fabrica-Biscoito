package UFLA.avancada.FabricaBiscoito.domain.fila;

import UFLA.avancada.FabricaBiscoito.domain.biscoito.Biscoito;
import UFLA.avancada.FabricaBiscoito.domain.forno.Forno1;
import UFLA.avancada.FabricaBiscoito.domain.forno.Forno2;
import UFLA.avancada.FabricaBiscoito.domain.linha.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Vector;

@Service
public class FilaBuilder {

    private LinhaProducao1 linhaProducao1 = new LinhaProducao1();
    private LinhaProducao1b linhaProducao1b = new LinhaProducao1b();
    private LinhaProducao1c linhaProducao1c = new LinhaProducao1c();
    private LinhaProducao2 linhaProducao2 = new LinhaProducao2();
    private LinhaProducao2b linhaProducao2b = new LinhaProducao2b();
    private LinhaProducao2c linhaProducao2c = new LinhaProducao2c();
    private LinhaProducao3 linhaProducao3= new LinhaProducao3();
    private LinhaProducao3b linhaProducao3b = new LinhaProducao3b();
    private LinhaProducao3c linhaProducao3c = new LinhaProducao3c();
    private Forno1 forno1 = new Forno1();
    private Forno2 forno2 = new Forno2();
    private List<Fila> listaFila = new Vector<Fila>();

    public FilaBuilder() {
        listaFila.add( new FilaProducao1(this.linhaProducao1, this.linhaProducao1b, this.linhaProducao1c, this.forno1));
        listaFila.add( new FilaProducao2(this.linhaProducao2, this.linhaProducao2b, this.linhaProducao2c, this.forno1, this.forno2));
        listaFila.add( new FilaProducao3(this.linhaProducao3, this.linhaProducao3b, this.linhaProducao3c, this.forno2));
    }

    public List<Fila> getListaFila () {
        return this.listaFila;
    }

    public synchronized Fila AdicionaBiscoito(Biscoito biscoito) {
        if(biscoito.getEhRecheado()) {
            if(this.getListaFila().get(0).getTamanho() < this.getListaFila().get(1).getTamanho()){
                this.getListaFila().get(0).adicionaBiscoito(biscoito);
                return this.getListaFila().get(0);
            } else {
                this.getListaFila().get(1).adicionaBiscoito(biscoito);
                return this.getListaFila().get(1);
            }
        } else {
            if(this.getListaFila().get(0).getTamanho() < this.getListaFila().get(1).getTamanho()){
                if(this.getListaFila().get(0).getTamanho() < this.getListaFila().get(2).getTamanho()) {
                    this.getListaFila().get(0).adicionaBiscoito(biscoito);
                    return this.getListaFila().get(0);
                } else {
                    this.getListaFila().get(2).adicionaBiscoito(biscoito);
                    return this.getListaFila().get(2);
                }
            } else if (this.getListaFila().get(1).getTamanho() < this.getListaFila().get(2).getTamanho()) {
                this.getListaFila().get(1).adicionaBiscoito(biscoito);
                return this.getListaFila().get(1);
            } else {
                this.getListaFila().get(2).adicionaBiscoito(biscoito);
                return this.getListaFila().get(2);
            }
        }
    }

}
