package UFLA.avancada.FabricaBiscoito.model.fila;

import UFLA.avancada.FabricaBiscoito.model.biscoito.Biscoito;
import UFLA.avancada.FabricaBiscoito.model.forno.Forno1;
import UFLA.avancada.FabricaBiscoito.model.forno.Forno2;
import UFLA.avancada.FabricaBiscoito.model.linha.LinhaProducao1;
import UFLA.avancada.FabricaBiscoito.model.linha.LinhaProducao2;
import UFLA.avancada.FabricaBiscoito.model.linha.LinhaProducao3;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Vector;

@Service
public class FilaBuilder {

    private LinhaProducao1 linhaProducao1 = new LinhaProducao1();
    private LinhaProducao2 linhaProducao2 = new LinhaProducao2();
    private LinhaProducao3 linhaProducao3= new LinhaProducao3();
    private Forno1 forno1 = new Forno1();
    private Forno2 forno2 = new Forno2();
    private List<Fila> listaFila = new Vector<Fila>();

    public FilaBuilder() {
        listaFila.add( new FilaProducao1(this.linhaProducao1, this.forno1));
        listaFila.add( new FilaProducao2(this.linhaProducao2, this.forno1, this.forno2));
        listaFila.add( new FilaProducao3(this.linhaProducao3, this.forno2));
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
