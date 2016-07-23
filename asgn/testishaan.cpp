    #include <bits/stdc++.h>
    #include "date.h"
    using namespace std;
    void testDateFormatConstructor()
    {
    	cout<<"Testing Date Format First Constructor true statements will be printed"<<endl<<endl;
    	const char*  day[]={NULL,"d","dd","ddd"};
    	const char*  month[]={NULL,"m","mm","mmm","mmmm"};
    	const char* year[]={NULL,"yy","yyyy","yyy"};
     
    	cout<<"Testing Dateformat(const char *,const char*,const char*)"<<endl<<endl;
    	cout<<"                 Status               :";cout<<" Strings Passed \n\n";
     
    	for(int i=0;i<4;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			for(int k=0;k<4;k++)
    			{	
    				try{
     
    					DateFormat f(day[i],month[j],year[k]);
    					cout<<"DateFormat type constructed with type : ";
    					if(day[i]== NULL)cout<<"NULL ";
    					else cout<<day[i]<<" ";
    					if(month[j]== NULL)cout<<"NULL ";
    					else cout<<month[j]<<" ";
    					if(year[k]== NULL)cout<<"NULL \n";
    					else cout<<year[k]<<" \n";
    				}
     
    				catch(invalid_argument e){
    					cout<<"Error in initialising DateFormat      : ";
     
    					if(day[i]== NULL)cout<<"NULL ";
    					else cout<<day[i]<<" ";
    					if(month[j]== NULL)cout<<"NULL ";
    					else cout<<month[j]<<" ";
    					if(year[k]== NULL)cout<<"NULL \n";
    					else cout<<year[k]<<" \n";
    				}
    				catch(...){
    					cout<<"Unknown Error"<<endl;
    				}
    			}
    		}
    	}
     
    	cout<<"\n\nTesting Dateformat(const char*)"<<endl<<endl;
    	cout<<"                 Status               :";cout<<" Strings Passed \n\n";
     
     
    	string  days[]={"-","d-","dd-","d","d"};
    	string  months[]={"-","m-","mm-","mmm-","mm"};
    	string years[]={"","yy","yyyy","-yy"};
     
    	for(int i=0;i<4;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			for(int k=0;k<4;k++)
    			{	
    				try{
     
    					DateFormat f((days[i]+months[j]+years[k]).c_str());
    					cout<<"DateFormat type constructed with type : "<<(days[i]+months[j]+years[k])<<endl;
     
    				}
     
    				catch(invalid_argument e){
    					cout<<"Error in initialising DateFormat      : "<<(days[i]+months[j]+years[k])<<endl;
     
    				}
    				catch(...){
    					cout<<"Unknown Error"<<endl;
    				}
    			}
    		}
    	}
     
    }
 void DateConstructor()
{
    Day day[]={D01,D28,D29,D31};
    Month month[]={Jan,Feb,Jul,Nov};
    Year year[]={1949,1950,2000,2049,2050};
 
    cout<<"----------------------------------------------------------\n";
    cout<<endl<<"Testing Date Constructor Date(day d,month m ,year y)\n\n";
    for(int i=0;i<4;i++)
    {
        for(int j=0;j<4;j++)
        {
            for(int k=0;k<5;k++)
            {
                try{
                    Date d(day[i],month[j],year[k]);
                    cout<<"Date  constructed with day   - "<<day[i]<<" month- "<<month[j]<<" year- "<<year[k]<<endl;
 
                }
                catch(invalid_argument e){
                    cout<<"Invalid Argument Error with day- "<<day[i]<<" month- "<<month[j]<<" year- "<<year[k]<<endl;
                }
                catch(out_of_range e){
                    cout<<"Out of Range Error with day  - "<<day[i]<<" month- "<<month[j]<<" year- "<<year[k]<<endl;
                }
                catch(domain_error e){
                    cout<<"Domain Error with day        - "<<day[i]<<" month- "<<month[j]<<" year- "<<year[k]<<endl;
                }
            }
        }
    }
 
    cout<<endl<<"Testing Date Constructor Date(const char*)\n\n";
    DateFormat format[]={DateFormat("dd","mm","yyyy"),DateFormat("dd",NULL,"yy"),DateFormat("dd","m","yy")};
    string days[]={"29-","31-","32-"};
    string months[]={"1-","2","03-","13-"};
    string years[]={"99","2016","2050"};
    for(int i=0;i<3;i++)
    {
        Date::setFormat(format[i]);
        for(int j=0;j<3;j++)
        {
            for(int k=0;k<4;k++)
            {
                for(int m=0;m<3;m++)
                {
                    try {
                        Date f((days[j]+months[k]+years[m]).c_str());
                        cout<<"Date Constructed with             "<<(days[j]+months[k]+years[m])<<endl;
                    }
                    catch(invalid_argument e){
                    cout<<"Invalid Argument Error with day-  "<<day[j]<<" month- "<<month[k]<<" year- "<<year[m]<<endl;
                    }
                    catch(out_of_range e){
                        cout<<"Out of Range Error with day  -    "<<day[j]<<" month- "<<month[k]<<" year- "<<year[m]<<endl;
                    }
                    catch(domain_error e){
                        cout<<"Domain Error with day       - "<<day[j]<<" month- "<<month[k]<<" year- "<<year[m]<<endl;
                    }
 
                }
            }
        }
    }
}

void unaryoperators(Date &dt)
{
    cout<<"\nTesting Unary Arithmetic Operators true statements will be printed"<<endl<<endl;
        try{
        Date d=dt;
            cout<<"++"<<d<<" is ";
            cout<<(++d)<<endl;
        } 
        catch(invalid_argument e){
            cout<<"Invalid Argument Error for "<<endl;
 
        }
        catch(domain_error e){
            cout<<"Domain Error"<<endl;
        }
        catch(out_of_range e){
            cout<<"Out Of Range Error ++Operator"<<endl;
        }
 
 
        try{
            Date d=dt;
            cout<<"--"<<d<<" is ";
            cout<<(--d)<<endl;
        } 
        catch(invalid_argument e){
            cout<<"Invalid Argument Error for "<<endl;
 
        }
        catch(domain_error e){
            cout<<"Domain Error"<<endl;
        }
        catch(out_of_range e){
            cout<<"Out Of Range Error --Operator"<<endl;
        }
 
        try{
            Date d=dt;
            cout<<d<<"++"<<" is ";cout<<(d++)<<endl;
 
        } 
        catch(invalid_argument e){
            cout<<"Invalid Argument Error for "<<endl;
 
        }
        catch(domain_error e){
            cout<<"Domain Error"<<endl;
        }
        catch(out_of_range e){
            cout<<"Out Of Range Error Operator++"<<endl;
        }
        try{
            Date d=dt;
            cout<<d<<"--"<<" is ";cout<<(d--)<<endl;
 
        } 
        catch(invalid_argument e){
            cout<<"Invalid Argument Error for "<<endl;
 
        }
        catch(domain_error e){
            cout<<"Domain Error"<<endl;
        }
        catch(out_of_range e){
            cout<<"Out Of Range Error Operator--"<<endl;
        }
 
}
void test_unary()
{
    DateFormat df("dd-mm-yyyy");
    Date::setFormat(df);
    Date a("28-02-1996");
    Date b("31-12-2049");
    Date c("01-01-1950");
    cout<<"-------------------------------------------------------------------------";
    unaryoperators(a);
    unaryoperators(b);
    unaryoperators(c);
 
}
void binaryoperators(Date &d,int x)
{
    cout<<d<<" + "<<x<<" is "<<(d+x);
    cout<<endl;
}
void test_binary()
{
    int arr[]={1,4,555,-365,366};
    DateFormat df("dd-mm-yyyy");
    Date::setFormat(df);
    Date a("28-02-1996");
    Date b("31-12-2049");
    Date c("01-01-1950");
    cout<<"-------------------------------------------------------------"<<endl;
    cout<<"Testing Adding Number Of Days true statements will be printed"<<endl<<endl;
    for(int i=0;i<5;i++)
    {
        try{
            binaryoperators(a,arr[i]);
        }
        catch (out_of_range e){
            cout<<"Out of range for "<<a<<" + "<<arr[i]<<endl;
        }
        try{
            binaryoperators(b,arr[i]);
        }
        catch (out_of_range e){
            cout<<"Out of range for "<<b<<" + "<<arr[i]<<endl;
        }
        try{
        binaryoperators(c,arr[i]);
        }
        catch (out_of_range e){
            cout<<"Out of range for "<<c<<" + "<<arr[i]<<endl;
        }   
    }
}
 
void difference_operator(Date &d1,Date &d2)
{
    cout<<"Testing Difference in days true statements will be printed"<<endl<<endl;
    cout<<d1<<" - "<<d2<<" is "<<(d1-d2)<<endl;
    cout<<d2<<" - "<<d1<<" is "<<(d2-d1)<<endl;
    cout<<endl;
}
 
void test_diff()
{   
    DateFormat df("dd-mm-yyyy");
    Date::setFormat(df);
    Date a("03-04-2016");
    Date b("03-04-2015");
    Date c("03-04-2017");
    difference_operator(a,b);
    difference_operator(c,b);
    difference_operator(a,c);
}
 
void LeapYear(Date & d1){
    cout<<"Testing LeapYear Function "<<endl<<endl;
    if(d1.leapYear()){
        cout<<d1<<" is a leap year"<<endl;
    }else{
        cout<<d1<<" is not a leap year"<<endl;
    }
    cout<<endl;
}
void test_leap()
{
    DateFormat df("dd-mm-yyyy");
    Date::setFormat(df);
    Date a("03-04-2016");
    Date b("03-04-2015");
    Date c("03-04-2017");
    LeapYear(a);
    LeapYear(b);
    LeapYear(c);
}
void CastOperators(Date & d1){
    cout<<"Testing Cast Operators "<<endl<<endl;
    cout<<d1<<" as WeekNumber is "<<static_cast<WeekNumber>(d1)<<endl;
    cout<<d1<<" as Month is "<<static_cast<Month>(d1)<<endl;
    cout<<d1<<" as WeekDay is "<<static_cast<WeekDay>(d1)<<endl;
    cout<<endl;
}
void test_cast()
{
    DateFormat df("dd-mm-yyyy");
    Date::setFormat(df);
    Date a("03-04-2016");
    Date b("03-04-2015");
    Date c("03-04-2017");
    CastOperators(a);
    CastOperators(b);
    CastOperators(c);
}
 
void RelationalOperators(Date & d1 , Date & d2){
    cout<<"Checking Relational Operators Only the Statements that are true will be printed"<<endl<<endl;
 
    if(d1!=d2)
    {
        cout<<d1<<" is != to "<<d2<<endl;   
    }
    if(d1==d2)
    {
        cout<<d1<<" is == to "<<d2<<endl;
    }
 
    if(d1<=d2)
    {
        cout<<d1<<" is <= than "<<d2<<endl;
    }
    if(d1<d2)
    {
        cout<<d1<<" is < than "<<d2<<endl;
    }
    if(d1>=d2)
    {
        cout<<d1<<" is >= than "<<d2<<endl;
    }
    if(d1>d2)
    {
        cout<<d1<<" is > than "<<d2<<endl;
    }
    cout<<endl;
}
void test_relation()
{
    DateFormat df("dd-mm-yyyy");
    Date::setFormat(df);
    Date a("03-04-2016");
    Date b("03-04-2015");
    Date c("03-04-2017");
    RelationalOperators(a,a);
    RelationalOperators(a,b);
    RelationalOperators(a,c);
    RelationalOperators(b,a);
    RelationalOperators(b,b);
    RelationalOperators(b,c);
    RelationalOperators(c,a);
    RelationalOperators(c,b);
    RelationalOperators(c,c);
}
void checkformarsetter()
{
    cout<<"Checking the format setter and getter \n";
    DateFormat f;
    Date::setFormat(f);
    Date d;
 
    cout<<"The default format dd-mmm-yy is set  using setFormat"<<endl;
    cout<<"The output  is "<<d<<endl;
    DateFormat f2("dd-mm-yyyy");
    Date::getFormat()=f2;
    cout<<"Changing the format using getFormat as reference is returned by that "<<endl;
    cout<<"The output in this format is "<<d<<endl;
 
    DateFormat f3("d-m-yy");
    Date::getFormat()=f3;
    cout<<"The output in this format is "<<d<<endl;
 
    cout<<"Set and Get Format Are Working Correctly"<<endl<<endl;
 
}
    int main()
    {
    	testDateConstructor();
    	return 0;
    }