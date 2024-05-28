//8-bit arithmetic and logical unit
module alu(
input [2:0]operation,
input [7:0]OperandA,OperandB,
output reg [7:0]result
    );
always @(*)begin
case(operation)
3'b000:
    result = OperandA + OperandB;
3'b001:
    result = OperandA - OperandB;
3'b010:
    result = OperandA / OperandB;
3'b011:
    result = OperandA * OperandB;  
3'b100:
    result = OperandA & OperandB; 
3'b101:
    result = OperandA | OperandB;
3'b110:
    result = ~OperandA;
3'b111:
    result = OperandA ^ OperandB;
default:
    result = 0;
    endcase
end
endmodule
