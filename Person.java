package shiwuzhou;

public class Person implements Comparable<Person> {
private String name;
private String ID;
private int age;
private String sex;
private String birthplace;

public String getname() 
{
    return name;
}
public void setname(String name) 
{
    this.name = name;
}
public String getID() 
{
    return ID;
}
public void setID(String ID) 
{
    this.ID= ID;
}
public int getage()
{
    return age;
}
public void setage(int age) 
{
    this.age= age;
}
public String getsex()
{
    return sex;
}
public void setsex(String sex)
{
    this.sex= sex;
}
public String getbirthplace() 
{
    return birthplace;
}
public void setbirthplace(String birthplace)
{
    this.birthplace= birthplace;
}

public int compareTo(Person o) 
{
   return this.name.compareTo(o.getname());
}

public String toString() 
{
    return  name+"\t"+sex+"\t"+age+"\t"+ID+"\t"+birthplace+"\n";

}



}