
#include <cstdlib>
#include "Date.h"


using namespace std;

void check_dateformat()
{
	cout<<"-----Constructor called is Dateformat(const char*, const char*, const char*) -----\n";
    	const char*  day[]={NULL,"d","dd","ddd"};
    	const char*  month[]={NULL,"m","mm","mmm","mmmm"};
    	const char* year[]={NULL,"yy","yyyy","yyy"};

     	for(int i=0;i<4;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			for(int k=0;k<4;k++)
    			{	
    				cout<<" Input : "<<((day[i] == NULL)? " NULL " : day[i]) << ((month[j] == NULL)? " NULL " : month[j] )<< ((year[k] == NULL)? " NULL " : year[k]) ;
    				cout<<"\n Output : ";
    				DateFormat df(day[i], month[j], year[k]);

    				cout<<((day[i] == NULL)? " NULL " : day[i]) << ((month[j] == NULL)? " NULL " : month[j] )<< ((year[k] == NULL)? " NULL " : year[k]) ;
    				cout<<"\n";
    			}
    		}
    	}

	cout<<"\n\n-----Constructor called is Dateformat(const char* ) -----\n\n";

	string  dd[]={"-","d-","dd-","d","d"};
	string  mm[]={"-","m-","mm-","mmm-","mm"};
	string  yy[]={"","yy","yyyy","-yy"};


	for(int i=0;i<4;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			for(int k=0;k<4;k++)
    			{	
    				cout<<" Input : "<<(dd[i] + mm[j] + yy[k]) ;
    				cout<<"\n Output : ";
    				DateFormat df((dd[i] + mm[j] + yy[k]).c_str());

    				cout<<(dd[i] + mm[j] + yy[k]) ;
    				cout<<"\n\n";
    			}
    		}
    	}


}
 void check_date()
{
    Day day[]={D01,D28,D29,D31};
    Month month[]={Feb,Mar,Sep};
    Year year[]={1949,1950,2000,2049,2050};
 
    cout<<"-----Date Constructor Date(day d,month m ,year y)-----\n\n";
    for(int i=0;i<4;i++)
    {
        for(int j=0;j<3;j++)
        {
            for(int k=0;k<5;k++)
            {
                try{

                	cout<<"Input:  Day- "<<day[i]<<" Month- "<<month[j]<<" Year- "<<year[k]<<"\n";
                	cout<<"Output: ";
                    Date d(day[i],month[j],year[k]);
                    cout<<" Day- "<<day[i]<<" Month- "<<month[j]<<" Year- "<<year[k]<<"\n\n";
 
                }
                catch(invalid_argument e){
                    cout<<e.what()<<"\n\n";
                }
                catch(out_of_range e){
                    cout<<e.what()<<"\n\n";
                }
                catch(domain_error e){
                    cout<<e.what()<<"\n\n";
                }
            }
        }
    }
 
    cout<<endl<<"\n\n -----Date Constructor Date(const char*)-----\n\n";
    DateFormat format[] = {DateFormat("dd",NULL,NULL),DateFormat("dd","mm","yyyy"),DateFormat("d","m","yy")};
    string days[] = {"2-","08-","29-","32-"};
    string months[] = {"2-","03-","09-","14-"};
    string years[] = {"85","2004","2050"};
    for(int i=0;i<3;i++)
    {
        Date::setFormat(format[i]);
        cout<<"saty\n";
        cout<<"Format is "<<((format[i].getdateFormat() == NULL)? " NULL " : format[i].getdateFormat())<<"-"<<((format[i].getmonthFormat() == NULL)? " NULL " : format[i].getmonthFormat())<<"-"<<((format[i].getyearFormat() == NULL)? " NULL " : format[i].getyearFormat())<<"\n";
        cout<<"--------------------------------------------------------------------------------\n";
        for(int j=0;j<4;j++)
        {
            for(int k=0;k<4;k++)
            {
                for(int l=0;l<3;l++)
                {
                    try {
                    	cout<<"Input: "<<(days[j]+months[k]+years[l]) <<"\n";
                		cout<<"Output: ";
                        Date d((days[j]+months[k]+years[l]).c_str());
                        cout<<(days[j]+months[k]+years[l])<<"\n\n";
                    }
                    catch(invalid_argument e){
                    cout<<e.what()<<"\n\n";
                    }
                    catch(out_of_range e){
                    cout<<e.what()<<"\n\n";
                    }
                    catch(domain_error e){
                    cout<<e.what()<<"\n\n";
                    }
 
                }
            }
        }
    }
}

void unary(Date& date)
{
	cout<<"\n Testing with date "<<date;
	cout<<"\n ----------------------------------\n";

	cout<<"\nOperator pre increment \n";
	try
	{
    	    Date d=date;
            cout<<(++d)<<"\n";
        } 
        catch(invalid_argument e){
                    cout<<e.what()<<"\n";
 
        }
        catch(domain_error e){
                    cout<<e.what()<<"\n";
        }
        catch(out_of_range e){
                    cout<<e.what()<<"\n";
        }
 
 cout<<"\nOperator post increment \n";
	try
	{
    	    Date d=date;
            cout<<(d++)<<"\n";
        } 
        catch(invalid_argument e){
                    cout<<e.what()<<"\n";
 
        }
        catch(domain_error e){
                    cout<<e.what()<<"\n";
        }
        catch(out_of_range e){
                    cout<<e.what()<<"\n";
        }
        cout<<"\nOperator pre decrement \n";
	try
	{
    	    Date d=date;
            cout<<(--d)<<"\n";
        } 
        catch(invalid_argument e){
                    cout<<e.what()<<"\n";
 
        }
        catch(domain_error e){
                    cout<<e.what()<<"\n";
        }
        catch(out_of_range e){
                    cout<<e.what()<<"\n";
        }
        cout<<"\nOperator post decrement \n";
	try
	{
    	    Date d=date;
            cout<<(d--)<<"\n";
        } 
        catch(invalid_argument e){
                    cout<<e.what()<<"\n";
 
        }
        catch(domain_error e){
                    cout<<e.what()<<"\n";
        }
        catch(out_of_range e){
                    cout<<e.what()<<"\n";
        }

}

void check_unary()
{

	cout<<"-----Checking unary operators-----\n";
	DateFormat df = DateFormat("dd-mm-yyyy");
	Date::setFormat(df);
	Date d1(D01, Jan, 1950);
	Date d2(D28, Feb, 2001);
	Date d3(D29, Feb, 2004);
	Date d4(D31, Dec, 2049);

	unary(d1);
	unary(d2);
	unary(d3);
	unary(d4);
}
void check_diff()
{
	cout<<"-----Checking Difference operator-----\n";
	Date d1(D04, Mar, 2003);
	Date d2(D28, Feb, 2003);

	cout<<"No. of days between "<<d1<<" and "<<d2<<" is "<<d1 - d2<<"\n";

}

void check_add()
{
	cout<<"-----Checking add operator-----\n";
	DateFormat df = DateFormat("dd-mm-yyyy");
	Date::setFormat(df);
	Date d1(D01, Jan, 1950);
	Date d2(D28, Feb, 2001);
	Date d3(D29, Mar, 2004);
	Date d4(D31, Dec, 2049);

	cout<<"Adding 22 days \n";
	cout<<"------------------------\n";
	try
	{
	cout<<d1<<" ------ > ";
	cout<<d1 + 22<<"\n";
	}
	 catch(invalid_argument e){
                    cout<<e.what()<<"\n";
 
        }
        catch(domain_error e){
                    cout<<e.what()<<"\n";
        }
        catch(out_of_range e){
                    cout<<e.what()<<"\n";
        }
	try{
		cout<<d2<<" ------ > ";
		cout<<d2 + 22<<"\n";
	 }catch(invalid_argument e){
                    cout<<e.what()<<"\n";
 
        }
        catch(domain_error e){
                    cout<<e.what()<<"\n";
        }
        catch(out_of_range e){
                    cout<<e.what()<<"\n";
        }
        try{
	cout<<d3<<" ------ > ";
	cout<<d3 + 22<<"\n";
	 }catch(invalid_argument e){
                    cout<<e.what()<<"\n";
 
        }
        catch(domain_error e){
                    cout<<e.what()<<"\n";
        }
        catch(out_of_range e){
                    cout<<e.what()<<"\n";
        }
        try{
        cout<<d4<<" ------ > ";
        cout<<d4 + 22<<"\n";
        } catch(invalid_argument e){
                    cout<<e.what()<<"\n";
 
        }
        catch(domain_error e){
                    cout<<e.what()<<"\n";
        }
        catch(out_of_range e){
                    cout<<e.what()<<"\n";
        }
}



void check_leap()
{
	cout<<"-----Checking leap year-----\n";
	DateFormat df = DateFormat();

	Date d1(D01, Jan, 1950);
	Date d2(D28, Feb, 2000);

	if(d1.leapYear() == 1)
		cout<<d1<<"----->Leap year\n";
	else
		cout<<d1<<"-----> not  leap year\n";

	if(d2.leapYear() == 1)
		cout<<d2<<"----->Leap year\n";
	else
		cout<<d2<<"-----> not  leap year\n";

}

void check_cast()
{
	cout<<"-----Checking cast oparators-----\n";
	Date d1(D02, Jan, 2016);
	cout<<"Month of "<<d1<<" is "<<Month(d1)<<"\n";
	cout<<"Weekday of "<<d1<<" is "<<WeekDay(d1)<<"\n";
	cout<<"WeekNumber of "<<d1<<" is "<<WeekNumber(d1)<<"\n";
	Date d2 = Date();
	cout<<"Month of "<<d2<<" is "<<Month(d2)<<"\n";
	cout<<"Weekday of "<<d2<<" is "<<WeekDay(d2)<<"\n";
	cout<<"WeekNumber of "<<d2<<" is "<<WeekNumber(d2)<<"\n";

}


void relational(Date& d1, Date& d2)
{
	if(d1 == d2)
	{
		cout<<d1<<" = "<<d2<<"\n";
	}
	if(d1 != d2)
	{
		cout<<d1<<" != "<<d2<<"\n";
	}
	if(d1 <= d2)
	{
		cout<<d1<<" <= "<<d2<<"\n";
	}
	if(d1 < d2)
	{
		cout<<d1<<" < "<<d2<<"\n";
	}
	if(d1 >= d2)
	{
		cout<<d1<<" >= "<<d2<<"\n";
	}
	if(d1 > d2)
	{
		cout<<d1<<" > "<<d2<<"\n";
	}
}

void check_relational()
{
	cout<<"-----Checking relational oparators-----\n";
	DateFormat df = DateFormat("dd-mm-yyyy");
	Date::setFormat(df);
	Date d1("20-02-1996");
	Date d2("19-04-1996");
	relational(d1, d1);
	cout<<"-----------\n";
	relational(d1, d2);
	cout<<"-----------\n";
	relational(d2, d1);
	
}

void check_output_format()
{
	cout<<"-----Checking Output Format-----\n";
	DateFormat df = DateFormat("dd-mm-yyyy");
	Date::setFormat(df);
	Date d("20-02-1996");
	

	cout<<"dd-mm-yyyy------>"<<d<<"\n";

	df = DateFormat("d-m-yy");
	Date::setFormat(df);

	cout<<"d-m-yy------>"<<d<<"\n";


	 df = DateFormat();
	Date::setFormat(df);

	cout<<"dd-mmm-yy------>"<<d<<"\n";

	df = DateFormat("dd--yyyy");
	Date::setFormat(df);

	cout<<"dd--yyyy------>"<<d<<"\n";
}

int main()
{
    cout<<"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n";
	check_dateformat();
    cout<<"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n";
	check_date();
    cout<<"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n";
    check_unary();
	cout<<"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n";
    check_diff();
	cout<<"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n";
	check_add();
	cout<<"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n";
	check_cast();
	cout<<"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n";
	check_leap();
	cout<<"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n";
	check_relational();
	cout<<"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n";
	check_output_format();


}

