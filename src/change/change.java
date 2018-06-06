package change;
import java.util.Vector;
public class change 
{
	static Vector<Integer> getChange(int chest[], int target)
	{ // reference: geeksforgeeks.org
		int upperBound = (int) 2e+12;
		int numberOfCoins = chest.length;
		int coinCount[] = new int[target + 1];
		Vector<Vector<Integer>> result = new Vector<Vector<Integer>>(target + 1);
		for (int i = 0; i < target + 1; i++) {
			result.add(new Vector<Integer>());
		}
		coinCount[0] = 0;
		for (int i = 1; i <= target; i++)
			coinCount[i] = upperBound;
		for (int i = 1; i <= target; i++)
		{
			for (int j = 0; j < numberOfCoins; j++)
				if (chest[j] <= i)
				{
					int sub_res = coinCount[i - chest[j]];
					if (sub_res != upperBound 
							&& sub_res + 1 < coinCount[i]) {
						coinCount[i] = sub_res + 1;
						result.elementAt(i).clear();
						for(Integer res : result.elementAt(i - chest[j]))
							result.elementAt(i).add(res);
						result.elementAt(i).addElement(new Integer(chest[j]));
					}
				}
		}
		return result.elementAt(target);
	}
	public static void main (String[] args) 
	{
		int coins[] = {9, 6, 5, 1};
		int m = coins.length;
		int V = 11;
		System.out.println ( "Minimum coins required is "
				+ getChange(coins,  V));
	}
}