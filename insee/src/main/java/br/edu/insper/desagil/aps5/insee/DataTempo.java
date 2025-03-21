package br.edu.insper.desagil.aps5.insee;

public class DataTempo extends Referencia {
    private Data data;
    private Tempo tempo;

    public DataTempo (Data data, Tempo tempo){
        this.data = data;
        this.tempo = tempo;
    }

    public Data getData(){return data;}
    private Tempo getTempo(){return tempo;}

    @Override
    public int comoInteiro() {
        data.atualiza(data.getAno(),data.getMes(), data.getDia()); //Nesse caso para acessar o método atualiza da classe data, basta chamar o método atualiza, a partir do atributo data, que é do tipo Data, que o java reconhece que ele deve chamar o atualiza da classe Data
        tempo.atualiza(tempo.getHora(), tempo.getMinuto());

        int minutosPassados = data.comoInteiro() * 24 * 60; //O mesmo se aplica aqui, deve-se chamar o método como inteiro a partir do atributo data,que é do tipo Data, que o java reconhece que ele deve utiliza o método comoInteiro pertencente a classe Data.
        minutosPassados += tempo.comoInteiro();

        return minutosPassados;
    }
}
