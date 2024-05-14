module restoring_div_R2(clk, reset, Dividend, Divisor, Quotient, Remainder);
	input clk, reset;
	input [63:0] Dividend, Divisor;
	output [63:0] Quotient, Remainder;
	reg [63:0] Quotient, Remainder;
	reg [63:0] A, Q, temp;
	integer i;
	always @(posedge clk, negedge reset)
	begin
		if( !reset )
		begin
			Quotient <= 0;
			Remainder <= 0;
		end
		else begin
			Quotient <= Q;
			Remainder <= A;
		end
	end
	always @(*) begin
		Q = Dividend;       
		A = 0;
		for(i = 0; i < 64; i = i+1)
		begin
			//Shift Left carrying Q's MSB into A's LSB
			A = (A << 1) | Q[63];
			Q =  Q << 1;

			//store value in case we have to restore
			temp = A;

			//Subtract
			A = A - Divisor;

			if( A[63] )         // if p < 0
				A = temp;   //restore value
			else
				Q = Q | 1;  //add 1 to the LSB
		end	
	end
				
endmodule
	
module restoring_div_R2_tb;
	reg clk, reset;
	reg [63:0] dividend, divisor;
	wire [63:0] quotient, remainder;

	restoring_div_R2 divider(clk, reset, dividend, divisor, quotient, remainder);

	initial
		forever #1 clk = ~clk;
	initial
		$monitor("%0d / %0d: q = %0d, r = %0d", dividend, divisor, quotient, remainder);
	initial
	begin
		clk = 0;
		reset = 0;

		#1;
		reset = 1;
		dividend = 4'b1010;
		divisor = 4'b0011;

		#5;
		dividend = 50;
		divisor = 25;

		#5;
		dividend = 64'hFFFF_FFFF_FFFF_FFFF;
		divisor = 2;

		#5;
		dividend = 32'h1234_5678;
		divisor = 1;

		#5;
		divisor = dividend;
	
		#5;
		$finish;
	end
endmodule
