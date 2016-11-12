    #include <iostream>
    #include <cstring>
    #include <cstdlib>

    using namespace std;

    string rand_gen_logExp(int);   

    int main()
    {
        int m = 50;
            cout<<rand_gen_logExp(m)<<endl;
        }

    string rand_gen_logExp (int n){
        if (n<=0)
            return "";
  
    //possible symbols in the expression
        string symbols = "FT()!*+";
        
    //possible symbols after each current symbol
        string succ[] = {"*+)","*+)", "!FT", "*+)", "FT(!", "FT(!", "FT(!"};
        
    //Ouput string initialized;
        string logical_exp = "";
  
    //number of left apparantheses generated so far

            int num_of_lp = 0;

    //initializz first symbol of the output

            char first_symbol = ' ';
    
    //randomly generate first symbol in the output
            
        //seed for rand
            srand(time(0));
            switch (rand() % 4)
            {
                case 0: first_symbol = 'F'; break;
                case 1: first_symbol = 'T'; break;
                case 2: first_symbol = '!'; break;
                case 3: first_symbol = '('; num_of_lp++;
            break;   
            }
        logical_exp += first_symbol;
    
    // The last symbol generated
        char last_symbol = first_symbol;
    // The main loop that generates the rest of the expression
        for(int i=1; i<n-num_of_lp; i++)
        {
    //string s = succ[symbols.indexOf(last_symbol)];
        string s = succ[symbols.find(last_symbol)];
        char next_symbol;
        bool again;
    // genrating the next symbol in the expression and
    // make sure that it conforms to format of loogical expressions
        do
        {
            again = false;
            next_symbol = s.at(rand() % (s.length()));
            switch (next_symbol)
                {
                    case ')': // All parantheses seen so far matched
                                // ) is not allowed for next symbol
                        if (num_of_lp==0)
                            {
                                again = true;
                            }
                        else
                            num_of_lp--;
                            break;

                    case '(': num_of_lp++;
                            break;
                        }
                }while(again);
                        logical_exp += next_symbol;
                        last_symbol = next_symbol;}
        
            // check if the last symbol is an operator and hence need an operand
                if ((last_symbol=='(' || last_symbol=='*' || last_symbol=='+' || last_symbol=='!'))
                        logical_exp += rand() % 2==0 ? 'F':'T';
            // adding necessary closing )'s
                for(int i=0; i<num_of_lp; i++)
                    logical_exp += ')';
                  return logical_exp;
    }