`timescale 1ns / 1ps

module half_adder(
    input in_1,in_2,
    output sum,carry
    );
    assign sum=in_1 ^ in_2;
    assign carry = in_1 & in_2;
endmodule
