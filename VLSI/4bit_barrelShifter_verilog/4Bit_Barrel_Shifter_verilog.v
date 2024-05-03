//initializing 2x1 mux to use on barrel shifter
module mux_2x1(in0,in1,sel,out);
input in0,in1,sel;
output out;
assign out=sel?in1:in0;
endmodule

//initializing 4bit barrel shifter
module b4bit_barrelshifter(in,sel,out);
input [3:0]in;
input [1:0]sel;
output [3:0]out;
wire [3:0]w;

mux_2x1 m1(in[0],in[2],sel[1],w[0]);   // connecting port list with position (can also be done with name)
mux_2x1 m2(in[1],in[3],sel[1],w[1]); 
mux_2x1 m3(in[2],in[0],sel[1],w[2]); 
mux_2x1 m4(in[3],in[1],sel[1],w[3]); 


mux_2x1 m5(w[0],w[1],sel[0],out[0]); 
mux_2x1 m6(w[1],w[2],sel[0],out[1]); 
mux_2x1 m7(w[2],w[3],sel[0],out[2]); 
mux_2x1 m8(w[3],w[0],sel[0],out[3]); 

endmodule      

//testbench
module test();
reg [3:0]in_tb;
reg [1:0]sel_tb;
wire [3:0]out_tb;
b4bit_barrelshifter dut(in_tb,sel_tb,out_tb);

initial begin
in_tb=4'b0000; sel_tb=2'b00;
#10 in_tb=4'b0001; sel_tb=2'b00;     //giving random inputs you can modify and verify according to your inputs
#10 in_tb=4'b0001; sel_tb=2'b01;
#10 in_tb=4'b0001; sel_tb=2'b10;
#10 in_tb=4'b0001; sel_tb=2'b11;

#10 in_tb=4'b1100; sel_tb=2'b00;
#10 in_tb=4'b1100; sel_tb=2'b01;
#10 in_tb=4'b1100; sel_tb=2'b10;
#10 in_tb=4'b1100; sel_tb=2'b11;

end
endmodule


