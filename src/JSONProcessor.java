import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONProcessor {

	public static JSONObject read(String input) {
		JSONObject obj = new JSONObject();
		String[] djelovi = input.split(": ");
		String nazivBankomata = djelovi[0];
		String[] djelici = djelovi[1].split(", ");
		JSONArray arr = new JSONArray();
		for (int i = 0; i < djelici.length; i++) {
			JSONObject objArr = new JSONObject();
			String da = djelici[i].trim();
			String tip = da.split("-")[0];
			int kolicina = Integer.parseInt(da.split("-")[1]);
			objArr.put("tip", tip);
			objArr.put("kolicina", kolicina);
			arr.add(objArr);
		}
		obj.put("naziv", nazivBankomata);
		obj.put("sadrzaj", arr);
		return obj;
	}

	public static List<Student> readJSON(String fajl) {
		List<Student> students = new ArrayList<Student>();
		JSONParser parser = new JSONParser();
		try {
			JSONObject obj = (JSONObject) parser.parse(new FileReader(fajl));
			JSONArray arr = (JSONArray) obj.get("students");
			for (Object o : arr) {
				JSONObject objArr = (JSONObject) o;
				String name = (String) objArr.get("name");
				long year = (long) objArr.get("year");
				String program = (String) objArr.get("program");
				JSONArray arrr = (JSONArray) objArr.get("courses");
				List<String> corses = new ArrayList<String>();
				for (Object e : arrr) {
					String namee = (String) e;
					corses.add(namee);
				}
				Student s = new Student(name, year, program, corses);
				students.add(s);
			}
			return students;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public static JSONArray filter(List<Student> students, String input) {

		int broj = 0;
		JSONArray arr = new JSONArray();

		if (input.contains(",")) {
			String[] inputi = input.split(",");
			for (int i = 0; i < inputi.length; i++) {
				String input1 = inputi[i];
				JSONObject obj = new JSONObject();
				obj.put("course", input1);
				JSONArray arrr = new JSONArray();
				for (Student s : students) {

					if (s.getCourses().contains(input1)) {

						arrr.add(s.getName());
					}

				}
				obj.put("prosli", arrr);
				arr.add(obj);
			}
		}
		return arr;
	}

	public static JSONObject createJSON(String input) {

		double ukupno = 0;
		JSONObject obj = new JSONObject();
		String[] djelovi = input.split(": ");
		String nazivKafica = djelovi[0];
		String[] djelici = djelovi[1].split(", ");
		JSONArray arr = new JSONArray();
		for (int i = 0; i < djelici.length; i++) {
			JSONObject arrObj = new JSONObject();
			String dio = djelici[i].trim();
			String porudzbina = dio.substring(0, dio.lastIndexOf(" "));
			double cijena = Double.parseDouble(dio.substring(dio.lastIndexOf(" ") + 1, dio.length()));
			arrObj.put("porudzbina", porudzbina);
			arrObj.put("cijena", cijena);
			arr.add(arrObj);
			ukupno += cijena;
		}
		double pdv = ukupno * 0.2;
		obj.put("ukupno", ukupno);
		obj.put("pdv", pdv);
		obj.put("porudzbine", arr);

		return obj;
	}

	public static List<Donut> readFile(String input) {
		List<Donut> donuts = new ArrayList<Donut>();
		JSONParser parse = new JSONParser();
		try {
			JSONArray arr = (JSONArray) parse.parse(new FileReader(input));
			for (Object o : arr) {
				ArrayList<Batter> batters = new ArrayList<Batter>();
				ArrayList<Topping> toppings = new ArrayList<Topping>();
				JSONObject e = (JSONObject) o;
				String id = (String) e.get("id");
				String type = (String) e.get("type");
				String name = (String) e.get("name");
				JSONObject obj2 = (JSONObject) e.get("batters");
				JSONArray arrr = (JSONArray) obj2.get("batter");
				for (Object da : arrr) {
					JSONObject daObj = (JSONObject) da;
					String id1 = (String) daObj.get("id");
					String type1 = (String) daObj.get("type");
					Batter b = new Batter(id1, type1);
					batters.add(b);

				}
				JSONArray arrrr = (JSONArray) e.get("topping");
				for (Object topping : arrrr) {
					JSONObject topObj = (JSONObject) topping;
					String id2 = (String) topObj.get("id");
					String type2 = (String) topObj.get("type");
					Topping t = new Topping(id2, type2);
					toppings.add(t);

				}
				Donut d = new Donut(id, type, name, batters, toppings);
				donuts.add(d);
			}
			return donuts;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public static JSONArray treciZad(List<Donut> donuts, String filter) {
		JSONArray arr = new JSONArray();
		for (Donut d : donuts) {
			boolean include = false;
			for (Batter b : d.getBatters()) {
				if (b.getType().contains(filter)) {
					include = true;
				}
			}
			if (!include) {
				for (Topping t : d.getToppings()) {
					if (t.getType().contains(filter)) {
						include = true;
					}
				}
			}
			if (include) {
				JSONObject obj = new JSONObject();
				obj.put("name", d.getName());
				JSONArray arr1 = new JSONArray();
				for (Batter b : d.getBatters()) {

					arr1.add(b.getType());
				}
				for (Topping t : d.getToppings()) {

					arr1.add(t.getType());
				}
				obj.put("sastojak", arr1);
				arr.add(obj);
			}
		}
		return arr;
	}
}
