package TrabArq.Part1;

import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class FiltrarPorRaca {
	public static void main(String[] args) {
		//configurando o Spark
	
		SparkConf conf = new SparkConf().setMaster("local").setAppName("DonoProcess");
		JavaSparkContext ctx = new JavaSparkContext(conf);
		
		//carregando os dados do txt file com os donos, pets, especies e raças
		
		JavaRDD<String> dados = ctx.textFile("C:/Users/DIANEDESantos/Box Sync/All files/Mackenzie/2 - Arquitetura de Big data/Trabalho Individual/Donos_Pets_Especie_Raca.txt");
		
		//filtrando os registros por raça
		
		JavaRDD<String> filtroRaca = dados.filter(f -> f.contains("Shih.Tzu"));
		
		//mostrando os pets filtrados
		List<String> resultados = filtroRaca.collect();
		for (String l : resultados) {
			System.out.println(l);
		}
		
		ctx.close();
	}
}