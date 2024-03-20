package temporary.data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import datalayer.data.Finding;

public class Findings {
	public static List<Finding> findingsList = new ArrayList<Finding>();

	static {
		initializeFindingsList();
	}

	private static void initializeFindingsList() {
//		Date date1 = Date.valueOf("2023-10-01");
//		findingsList.add(new Finding(1, "Старинная монета", "Очень редкая монета", date1, "Музей", "Деньги"));
//
//		Date date2 = Date.valueOf("2023-09-15");
//		findingsList.add(new Finding(2, "Древний амфора", "Амфора времен древней Греции", date2, "Подводная археология",
//				"Артефакты"));
//
//		Date date3 = Date.valueOf("2023-08-20");
//		findingsList.add(new Finding(3, "Зуб динозавра", "Древний зуб тираннозавра", date3, "Палеонтологический музей",
//				"Палеонтология"));
//
//		Date date4 = Date.valueOf("2023-07-10");
//		findingsList.add(new Finding(4, "Средневековый меч", "Древний меч времен рыцарей", date4, "Замок", "История"));
//
//		Date date5 = Date.valueOf("2023-06-25");
//		findingsList.add(new Finding(5, "Сокровище корсара", "Находка с пиратского корабля", date5, "Подводный поиск",
//				"Артефакты"));
//
//		Date date6 = Date.valueOf("2023-05-15");
//		findingsList.add(new Finding(6, "Драгоценный камень", "Бриллиант в сыром виде", date6, "Шахта", "Геология"));
//
//		Date date7 = Date.valueOf("2023-04-03");
//		findingsList.add(new Finding(7, "Древний свиток", "Свиток с древними текстами", date7,
//				"Археологические раскопки", "Артефакты"));
//
//		Date date8 = Date.valueOf("2023-03-10");
//		findingsList.add(new Finding(8, "Костяной артефакт", "Древний артефакт из кости", date8, "Музей антропологии",
//				"Артефакты"));
	}
}
