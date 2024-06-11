`timescale 1ns / 1ps

module Basic_Gates(
    input in_1,in_2,in_3,in_4,       //input declaration
    output out_not,out_and,out_or,out_nand,out_nor,out_xor,out_xnor   //output declaration
    );
    //Gate level modelling
    /*
    not Gate_1(out_not,in_1);
    and Gate_2(out_and,in_1,in_2);
    or Gate_3(out_or,in_1,in_2,in_3,in_4);
    nand Gate_4(out_nand,in_1,in_2);
    nor Gate_5(out_nor,in_1,in_2);
    xor Gate_6(out_xor,in_1,in_2);
    xnor Gate_7(out_xnor,in_1,in_2,in_3,in_4); */
    
    //Data-Flow Modelling
    assign out_not = (!in_1);       // not represented by ! or ~
    assign out_and = in_1 & in_2;   // and represented by &
    assign out_or = in_1 | in_2 | in_3 | in_4;  //or represented by |
    assign out_nand = !(in_1 & in_2);    // nand represented by !(a&b)
    assign out_nor = !(in_1 | in_2);     // nor represented by !(a|b)
    assign out_xor = in_1 ^ in_2 ^ in_3 ^ in_4;   //exor represented by ^
    assign out_xnor = !(in_1 ^ in_2);    // enor represented by !(a^b)
   
endmodule
