`timescale 1ns / 1ps

module TB_half_adder();
reg in_1tb,in_2tb;
wire sum_tb,carry_tb;

half_adder dut(in_1tb,in_2tb,sum_tb,carry_tb);

initial begin 
in_1tb=0; in_2tb=0; #10
in_1tb=0; in_2tb=1; #10
in_1tb=1; in_2tb=0; #10
in_1tb=1; in_2tb=1; 
end
endmodule
