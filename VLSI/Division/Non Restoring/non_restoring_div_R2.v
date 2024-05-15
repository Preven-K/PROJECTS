module non_restoring_div(clk, reset, Dividend, Divisor, Quotient, Remainder);
	input clk, reset;
	input [63:0] Dividend, Divisor;
	output [63:0] Quotient, Remainder;
	reg [63:0] Quotient, Remainder;
	reg [63:0] A, Q, temp;
	integer i;
	always @(posedge clk, negedge reset) begin
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
			A = (A << 1) | Q[63];      //Shift Left carrying Q's MSB into A's LSB
			Q = Q << 1;                //Check the old value of p
			if( A[63] )                //if A<1 ie. is negative
				temp = Divisor;    //add divisor(A+B)(where B is Divisor)
			else
				temp = ~Divisor+1;  //subtract divisor (A-B)
			A = A + temp;                //this will do the appropriate add or sub depending on the value of temp
			
			if( A[63] ) //Check the new value of A .if A is negative ie. A==1
				A = A | 0; //no change to quotient
			else
				A = A | 1; 
		end
		if( A[63] ) ////Correction is needed if remainder is negative ie. if p is negative
			A = A + Divisor;
	end
				
endmodule

module non_restoring_div_tb;
	reg clk, reset;
	reg [63:0] dividend, divisor;
	wire [63:0] quotient, remainder;

	non_restoring_div divider(clk, reset, dividend, divisor, quotient, remainder);

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
		dividend = 87;
		divisor = 5;

		#5;
		dividend = 59;
		divisor = 20;

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
