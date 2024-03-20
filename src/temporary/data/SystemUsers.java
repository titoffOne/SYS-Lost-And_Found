package temporary.data;

import java.util.ArrayList;
import java.util.List;

import datalayer.data.SystemUser;

public class SystemUsers {
	public static List<SystemUser> userList = new ArrayList<SystemUser>();
	public static List<SystemUser> clientsList = new ArrayList<SystemUser>();

	static {
		//initializeUserList();
		initializeOnlyClients();
	}

//	private static void initializeUserList() {
//		userList.add(new SystemUser(1, "Петров Иван Владимирович", "+7 910 630-10-56", "vanya@mail.ru", "adm", "0000",
//				"Активен", "Администратор"));
//		userList.add(new SystemUser(2, "Титов Антон Максимович", "+7 910 630-10-56", "vanya@mail.ru", "adm", "anton",
//				"Активен", "Администратор"));
//		userList.add(new SystemUser(3, "Ярошенко Анастасия Михайловна", "+7 910 630-10-56", "vanya@mail.ru", "adm",
//				"nastya", "Активен", "Приемщик"));
//		userList.add(new SystemUser(4, "Иванов Михаил Александрович", "+7 910 630-10-56", "vanya@mail.ru", "adm",
//				"0000", "Заблокирован", "Клиент"));
//	}
	
	
	private static void initializeOnlyClients() {
		for (SystemUser user : SystemUsers.userList) {
			if (user.getGroup().equals("Клиент")) {
				clientsList.add(user);
			}

		}
	}



}
