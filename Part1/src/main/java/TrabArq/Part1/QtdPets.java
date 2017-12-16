package TrabArq.Part1;

import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class QtdPets {
	public static void main (String[] args) {
		//configurando o Spark
	
		SparkConf conf = new SparkConf().setMaster("local").setAppName("DonoProcess");
		JavaSparkContext ctx = new JavaSparkContext(conf);
		
		//carregando os dados do txt file com os donos, pets, especies e raças
		
		JavaRDD<String> dados = ctx.textFile("C:/Users/DIANEDESantos/Box Sync/All files/Mackenzie/2 - Arquitetura de Big data/Trabalho Individual/Donos_Pets_Especie_Raca.txt");
		
		//fazendo o map com os nomes dos donos
		JavaPairRDD<String, Integer> agrupaDono = dados.mapToPair(f -> new Tuple2<String, Integer>(f.split(" ")[1], 1));
		JavaPairRDD<String, Integer> numeroPet = agrupaDono.reduceByKey((x, y) -> x + y);
		List<Tuple2<String, Integer>> lista = numeroPet.collect();

		//mostrando os donos e a quantidade de pets
		for (Tuple2<String, Integer> qtdPet : lista) {
			System.out.println("Dono: " + qtdPet._1());
			System.out.println("Quantidade de pets: " + qtdPet._2());
		}
	}
}
