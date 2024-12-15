package fabrik;

public class ConcreteCreatorB extends Creator
{
	public Product factoryMethod()
	{
		return new ConcreteProductB();
	}
}
