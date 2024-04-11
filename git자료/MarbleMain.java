//카멜 케이스

//1. 클래스 이름은 대문자로 시작한다.
//ex) class PrimeNumber
//2. 메소드 이름과 변수이름은 소문자로 시작한다.
//public void isPrimeNumber()
//int primeNumber
//3. 단어와 단어가 만나는 첫 글자는 대문자로 준다.
//primeNumber
//4. 심볼릭 콘스탄트(Symbolic Constant)는 전체를 대문자로 주는데
//단어와 단어가 만나는 부분을 언더바(_)로 연결한다.
//PRIME_NUMBER

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
다음 조건을 만족하는 클래스를 정의해보자.

* 어린아이가 소유하고 있는 구슬의 개수 정보를 담을 수 있다.
* 놀이를 통한 구슬의 주고받음을 표현하는 메소드가 존재한다.
* 어린이의 현재 보유자산(구슬의 수)을 출력하는 메소드가 존재한다.

위의 두 번째 조건은 두 아이가 구슬치기를 하는 과정에서 구슬의 잃고 얻음을 의미하는 것이다.
(이 문제 마지막까지 읽어야 필요한 메소드가 무엇인지 정확히 파악할 수 있다.)
위의 조건을 만족하는 클래스를 정의하였다면, 다음 조건을 만족하는 인스턴스를 각각 생성하자.

* 어린이1의 보유자산 -> 구슬 15개
* 어린이2의 보유자산 -> 구슬 9개

인스턴스의 생성이 완료되면 다음의 상황을 main 메소드 내에서 시뮬레이션 하자.
"1차 게임에서 어린이1은 어린이2의 구슬 2개를 획득한다."
"2차 게임에서 어린이2는 어린이1의 구슬 7개를 획득한다."

마지막으로 각각의 어린이가 보유하고 있는 구슬의 수를 출력하면서 프로그램을 종료한다.

*/

/*
class MarbleGame
{
	int numOfOne = 0;
	int numOfTwo = 0;
	//int changeNum = 0;

	public MarbleGame(int numOfOne, int numOfTwo) //생성자로
	{
		this.numOfOne = numOfOne;
		this.numOfTwo = numOfTwo;
		System.out.println("아이1의 시작갯수 : " + this.numOfOne);
		System.out.println("아이2의 시작갯수 : " + this.numOfTwo);
		System.out.println("\n\n\n");	
	}

	public void exchangeMarble( int changeNum)
	{
		this.numOfOne += changeNum;
		this.numOfTwo -= changeNum;
		System.out.println("교환한 개수 : " + changeNum);
		System.out.println("\n\n\n");
	}
	
	public void finalStatement()
	{
		System.out.println("아이1의 최종갯수 : " + this.numOfOne);
		System.out.println("아이2의 최종갯수 : " + this.numOfTwo);
		System.out.println("\n\n\n");		
	} 
			
}

class MarbleMain
{
	public static void main(String[] args)
	{
		MarbleGame num1 = new MarbleGame(15, 9);

		num1.exchangeMarble(2);
		num1.exchangeMarble(-7);
		num1.finalStatement();
	}
}


*/

class Child
{
	String name;
	int beads;

	public Child(String name, int beads)
	{
		this.name = name;
		this.beads = beads;  //갖고있는 구슬
	}

	public void win(Child child, int beads)
	{
		this.beads += child.lose(beads); // this.beads += beads 는 왜 안돼???
	}

	public int lose(int beads)
	{
		if(this.beads < beads) // 줘야 될것이 내 수중의 것보다 많을때!
		{
			int temp = this.beads;
			this.beads = 0;
			return temp;
		}
		
		this.beads -= beads;
		return beads;
	}

	public void printCS()
	{
		System.out.println(name + "  " + beads);
	}
}	



class ChildMain
{
	public static void main(String[] args)
	{
		Child child1 = new Child("어린이1", 15);
		Child child2 = new Child("어린이2", 9);

		child1.win(child2,10 );

		child1.printCS();
		child2.printCS();
	}
}













