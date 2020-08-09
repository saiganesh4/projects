class Stack{

  is_empty():Bool
  { 
       true
  };
  head():Int
  {
      0
  };
  tail():Stack
  {
      self
  };
  pop():Stack
  {
    self
  };
  push(no:Int):Stack{
      (new Fulls).insert(no,self)
  };

};

class Fulls inherits Stack
{
    top:Int;
    tail:Stack;
    is_empty():Bool{
        false
    };
      head():Int
      {
          top
      };
      tail():Stack
      {
          tail
      };
   
   pop():Stack{
       let temp:Stack in {
           top<-tail.head();
           temp<-tail;
           tail<-tail.tail();
           temp;
       }
   };

   insert(no:Int,t:Stack):Stack
   { { top<-no;
       tail<-t;
       self;
     }  
   };

};
class Main inherits IO
{
       s:Stack;
       status:Int<-1;
       count:Int;
       n:Int;

       or(s:Bool,t:Bool):Bool
       {
        
           if s 
           then true
           else
           { if t then true
             else
              false
             fi;
           }
           fi
        
       };
       print(s:Stack):Object
       {
           if(s.is_empty()) 
           then out_string("\n")
           else
           {
               out_int(s.head());
               out_string(" ");
               print(s.tail());
           }
          fi

       };
       main():Object
       {
        {   
         out_string("      STACK      \n");
         out_string(" Give the status value accordingly\n if status is 1,push operation will done\n");
         out_string("if status is 2,pop operation will be done \n and assign any other value to status to exit the program\n");
         while or(status=1,status=2) loop
         {
           out_string("status= ");
           status<-in_int();
           if status=1
           then
           {     out_string("enter a number to insert\n");
                 n<-in_int();
                if count=0
                then
                 {
                     s<-(new Stack).push(n); 
                 }
                 else
                 {
                        s<-s.push(n);
                 }
                 fi;
                 count<-count+1;
                 out_string("stack after inserting:\n");
                 print(s);

           }
           else
           { 
               if status=2
               then
               {
                   s<-s.pop();
                   if 0<count then count<-count-1 else count<-0 fi;
                   out_string("stack after pop:\n");
                   print(s);
               }
               else
               {
                out_string("program is terminated\n");
               }
               fi;

           }
           fi;
         }pool;
        }

       };
};
