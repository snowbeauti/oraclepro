package com.javaex.phone;

import java.util.List;
import java.util.Scanner;

public class PersonApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		PersonDao personDao = new PersonDao();
		List<PersonVo> personList;

		int menu;
		
		while (run) {
			
			System.out.println("1.리스트  2.등록  3.수정  4.삭제  5.검색  6.종료");
			System.out.println("-------------------------------------");
			System.out.print("메뉴번호: ");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				
				// 1.리스트
				System.out.println("<1.리스트>");
				personList = personDao.getPersonList();
				
				for (int i = 0; i < personList.size(); i++) {
					PersonVo vo = personList.get(i);
					System.out.println(
							vo.getPersonId() + ".\t" + vo.getName() + "\t" + vo.getHp() + "\t" + vo.getCompany());
				}
				break;

			case 2:
				// 2.등록
				System.out.println("<2.등록>");
				sc.nextLine();
				System.out.print("이름>");
				String rname = sc.nextLine();
				System.out.print("휴대전화>");
				String rhp = sc.nextLine();
				System.out.print("회사번호>");
				String rcompany = sc.nextLine();
				
				

				PersonVo vo1 = new PersonVo();
				vo1.setName(rname);
				vo1.setHp(rhp);
				vo1.setCompany(rcompany);
								
				
				personDao.personInsert(vo1);
				personList = personDao.getPersonList();
				break;

			case 3:
				// 3.수정
				System.out.println("<3.수정>");
				sc.nextLine();
				System.out.print("번호>");
				int cnum = sc.nextInt();
				sc.nextLine();
				System.out.print("이름>");
				String cname = sc.nextLine();
				System.out.print("휴대전화>");
				String chp = sc.nextLine();
				System.out.print("회사번호>");
				String ccompany = sc.nextLine();
				
				PersonVo vo2 = new PersonVo();
				vo2.setName(cname);
				vo2.setHp(chp);
				vo2.setCompany(ccompany);
				vo2.setPersonId(cnum);
								
	
				personDao.personUpdate(vo2);
				break;

			case 4:
				// 4.삭제
				System.out.println("<4.삭제>");
				sc.nextLine();
				System.out.print("번호>");
				int dnum = sc.nextInt();
				
				personDao.PersonDelete(dnum);
				break;

			case 5://검색
				System.out.println("<5.검색>");
				sc.nextLine();
				System.out.print("검색어>");
				String word = sc.nextLine();
				personDao.personSearch(word);
				break;		
								
			case 6:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				
			default:
				System.out.println("다시입력해주세요.");

			}

			
		}
		sc.close();
	}

}
