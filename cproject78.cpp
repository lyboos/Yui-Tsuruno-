#include <iostream> 
using namespace std; 

void fun(int n, int r)
{
    if (1 == n)
    {
        switch(r)
        {
        case 0:cout<<"2(0)";break;
        case 1:cout<<"2";break;
        case 2:cout<<"2(2)";break;
        default:
            cout<<"2(";
            fun(r,0);
            cout<<")";
        }
    }
    else
    {
        fun(n/2, r+1);
        if (1 == n%2)
        {
            switch(r)
            {
            case 0:cout<<"+2(0)";break;
            case 1:cout<<"+2";break;
            case 2:cout<<"+2(2)";break;
            default:
                cout<<"+2(";
                fun(r,0);
                cout<<")";
            }
        }
    }
}

int main(void)
{
	int num;
	cin>>num;
	fun(num,0);
	return 0;
}
