`timescale 1ns / 1ps


module TB_Basic_Gates();

    reg in_1tb, in_2tb, in_3tb, in_4tb;
    wire out_not, out_and, out_or, out_nand, out_nor, out_xor, out_xnor;
    
    Basic_Gates uut(in_1tb,in_2tb, in_3tb, in_4tb,out_not, out_and, out_or, out_nand, out_nor, out_xor, out_xnor);
    
    initial 
    begin 
    in_1tb=0; in_2tb=0; in_3tb=0; in_4tb=0;#10
    in_1tb=0; in_2tb=0; in_3tb=0; in_4tb=1;#10
    in_1tb=0; in_2tb=0; in_3tb=1; in_4tb=1;#10
    in_1tb=0; in_2tb=1; in_3tb=1; in_4tb=1;#10
    in_1tb=1; in_2tb=1; in_3tb=1; in_4tb=0;#10
    in_1tb=1; in_2tb=1; in_3tb=1; in_4tb=1;#10
    in_1tb=1; in_2tb=1; in_3tb=0; in_4tb=0;#10
    in_1tb=1; in_2tb=0; in_3tb=0; in_4tb=0;
    end
endmodule
