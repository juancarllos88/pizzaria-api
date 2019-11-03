package br.com.pizzaria.core.api.infrastructure.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GeradorDeCodigo {

    public  static  void main(String args[]){



        System.out.println("sssssssssssss");
        System.out.println("sssssssssssss");

        System.out.println("sssssssssssss");
        System.out.println("sssssssssssss");
        System.out.println("sssssssssssss");
        System.out.println("sssssssssssss");
        System.out.println("sssssssssssss");
        System.out.println("sssssssssssss");





        // Diretorio dos modelos:   C:\Ambiente Shield\app-core\src\main\resources\model

        //C:\Ambiente Shield\app-core\src\main\java\br\com\app\core\dao
        //C:\Ambiente Shield\app-core\src\main\java\br\com\app\core\model
        //C:\Ambiente Shield\app-core\src\main\java\br\com\app\core\repository
        //C:\Ambiente Shield\app-core\src\main\java\br\com\app\core\service
        //C:\Ambiente Shield\app-core\src\main\java\br\com\app\core\controller
/*

        String entidade = "PermissaoPerfil";

        List<String> listaPathArquivos = new ArrayList<String>();

        listaPathArquivos.add("C:\\Ambiente Shield\\app-core\\src\\main\\java\\br\\com\\app\\core\\model\\Modelo.java");
        listaPathArquivos.add("C:\\Ambiente Shield\\app-core\\src\\main\\java\\br\\com\\app\\core\\controller\\ModeloController.java");
        listaPathArquivos.add("C:\\Ambiente Shield\\app-core\\src\\main\\java\\br\\com\\app\\core\\dao\\ModeloDao.java");
        listaPathArquivos.add("C:\\Ambiente Shield\\app-core\\src\\main\\java\\br\\com\\app\\core\\repository\\ModeloRepository.java");
        listaPathArquivos.add("C:\\Ambiente Shield\\app-core\\src\\main\\java\\br\\com\\app\\core\\service\\ModeloService.java");



        List<String> listaArquivosModelo = new ArrayList<String>();

        listaArquivosModelo.add("C:\\Ambiente Shield\\app-core\\src\\main\\resources\\model\\Modelo.java");
        listaArquivosModelo.add("C:\\Ambiente Shield\\app-core\\src\\main\\resources\\model\\ModeloController.java");
        listaArquivosModelo.add("C:\\Ambiente Shield\\app-core\\src\\main\\resources\\model\\ModeloDao.java");
        listaArquivosModelo.add("C:\\Ambiente Shield\\app-core\\src\\main\\resources\\model\\ModeloRepository.java");
        listaArquivosModelo.add("C:\\Ambiente Shield\\app-core\\src\\main\\resources\\model\\ModeloService.java");


        for(int i = 0; i < listaPathArquivos.size(); i++){

            listaPathArquivos.set(i, listaPathArquivos.get(i).replace("Modelo", entidade));
            //arquiNovo = arquiNovo.replace("Modelo", entidade);

        }



        for(int i = 0; i < listaPathArquivos.size(); i++){

            System.out.println(listaPathArquivos.get(i));
            editarArquivos(entidade, listaPathArquivos.get(i), listaArquivosModelo.get(i));

        }
*/
        //1º Criar todos os arquivos .java


        //criarArquivosJava(modelo);
       // editarArquivos(modelo, listaArquivosModelo);
        //2º editar arquivos
    }



    public static  void  editarArquivos(String nomeEntidade, String novoArquivo, String arquivoModelo ){

        try {
            FileReader arq = new FileReader(arquivoModelo);
            BufferedReader lerArquivo = new BufferedReader(arq);

            String linha = "";

            FileWriter arqEdit;
            arqEdit = new FileWriter(new File(novoArquivo));

            while (linha != null){
                linha = lerArquivo.readLine();


                if(arqEdit != null && linha != null){


                    if (linha.contains("Modelo")){
                        linha = linha.replace("Modelo", nomeEntidade);

                    }

                    if (linha.contains("modelo")){
                        linha = linha.replace("modelo", nomeEntidade.toLowerCase());

                    }

                    linha = linha+"\r\n";

                    arqEdit.write(linha);

                }


                System.out.println(linha);


            }

            arq.close();
            arqEdit.close();
            lerArquivo.close();

            System.out.println("finalizada a escrita");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
