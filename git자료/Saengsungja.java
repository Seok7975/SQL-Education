//생성자
//1. 생성자의 이름과 클래스의 이름은 대소문자하나까지 완벽하게 같아야 한다.
//2. 반환하는 값이 있어서도 안되고, 정의해서도 안된다.
//3. 생성자에서는 상수를 초기화 할 수 있다.(메소드에서는 상수를 초기화 할 수 없다.)
//4. 모든 클래스는 반드시 생성자를 갖고 있어야 한다.
//생성자를 만들지 않으면 디폴트 생성자가 자동으로 삽입된다. 생성자를 만들면 디폴트 생성자가 삽입이 안된다.
//멤버변수를 초기화할때 사용


class Triangle
{
	int width;
	int height;
	int area;    /final int AREA -> 값을 한번만초기화  멤버변수의 값은 메소드 내에서 초기화 불가

	public Triangle(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	public void areaOfTriangle()
	{
		area = width * height / 2;
	}
	public void printCS()
	{
		System.out.println("밑변 : " + width);
		System.out.println("높이 : " + height);
		System.out.println("넓이 : " + area);
	}
}
class TriangleMain
{
	public static void main(String[] args)
	{
		Triangle t1 = new Triangle(10, 5);
		//t1.initTriangle(10, 5);
		t1.areaOfTriangle();
		t1.printCS();

		Triangle t2 = new Triangle(4, 2);
		//t2.initTriangle(4, 2);
		t2.areaOfTriangle();
		t2.printCS();

		Triangle t3 = new Triangle(20, 10);
		//t3.initTriangle(20, 10);
		t3.areaOfTriangle();
		t3.printCS();
	}
}


/*
class sellerApple //
{
	int applePrice;
	int numOfApple=0, sellerMoney=0;
	
	public sellerApple(int applePrice, int numOfApple, int sellerMoney) //
	{
		this.applePrice = applePrice;
		this.numOfApple = numOfApple;
		this.sellerMoney = sellerMoney;
	}

	public int sell(int buyerMoney)
	{
		int num = buyerMoney / applePrice; //산(판) 개수
		this.numOfApple -= num; // 남은 개수
		this.sellerMoney += buyerMoney;  // 돈 = 있던 돈 + 판 돈
		return num; //판매 갯수 = 산 갯수		
	}

	public void printSellerStatement()
	{
		System.out.println("사과 가격 : " + this.applePrice);
		System.out.println("돈 : " + this.sellerMoney);
		System.out.println("사과 갯수 : " + this.numOfApple);
	}
}
class buyerApple //
{
	int numOfApple = 0, buyerMoney = 0;
	
	public buyerApple(int buyerMoney) //
	{
		this.numOfApple = numOfApple;
		this.buyerMoney = buyerMoney;
	}

	public void buy(sellerApple seller, int money)
	{
		this.buyerMoney -= money;
		this.numOfApple += seller.sell(money);
	}

	public void printBuyerStatement()
	{
		System.out.println("사과 갯수 : " + numOfApple);	
		System.out.println("돈 : " + buyerMoney);
	}	
}

class FruitMain
{
	public static void main(String[] args)
	{
		sellerApple seller1 = new sellerApple(2000, 50, 50000); //
		//seller1.initFruitSeller(2000, 50, 50000);
	
		sellerApple seller2 = new sellerApple(1000, 100, 100000); //
		//seller2.initFruitSeller(1000, 100, 100000);

		buyerApple buyer = new buyerApple(20000); //
		//buyer.initFruitBuyer();

		buyer.buy(seller1, 6000);
		seller1.printSellerStatement();
		System.out.print("\n\n");
		seller2.printSellerStatement();
		System.out.print("\n\n");
		buyer.printBuyerStatement();
		System.out.print("\n\n");
	}
}
*/