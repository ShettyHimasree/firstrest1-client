package com.tcs.boot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tcs.boot.entity.Loan;

@RestController
@RequestMapping("/client/loan/api/v1.0")
public class LoanController {
	
	@Autowired
	RestTemplate template;
	
	//@PostMapping("/create")
	@PostMapping(value = "/create", consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Loan> loanApplication(@RequestBody Loan loan) {
		HttpEntity requestEntity=new HttpEntity<>(loan);
		template.exchange("http://localhost:3333/loan/api/v1.0/create", HttpMethod.POST, requestEntity, 
				new ParameterizedTypeReference<List<Loan>>() {});
		return null;
	}
	
	@GetMapping("/fetch/{id}") //http://localhost:9990/loan/api/v1.0/fetch/1
	public ResponseEntity<Loan> getLoan(@PathVariable Long id) {
		
		String urlString="http://localhost:3333/loan/api/v1.0/fetch/"+id;
		Loan loan=template.getForObject(urlString, Loan.class);
		
		return ResponseEntity.ok(loan);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Loan>> getLoans(){
		ResponseEntity<List<Loan>> responseEntity=
		template.exchange("http://localhost:8191/loan/api/v1.0/all", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Loan>>() {});
	List<Loan> listOfLoans= responseEntity.getBody();
	return ResponseEntity.ok(listOfLoans);
	}
	
	
	 @PutMapping("/modify") public Loan doUpdate(@RequestBody Loan loan) { 
	  
;
return loan; }
	 
	
	@PutMapping("/modify2")
	public Loan doUpdate2(@RequestBody Loan loan) {
		return null;
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		String urlString="http://localhost:9990/loan/api/v1.0/remove/"+id;
		template.delete(urlString);
		
		return ResponseEntity.accepted().build();
	}
	
	/*
	 * @ExceptionHandler(value = {IllegalArgumentException.class})
	 * 
	 * @ResponseStatus(HttpStatus.BAD_REQUEST) public ResponseEntity<Map<String,
	 * String>> handleHandler(IllegalArgumentException ex){ Map<String, String>
	 * errorMap=new HashMap<>(); errorMap.put("Loanid", ex.getMessage()); return
	 * ResponseEntity.status(400).body(errorMap);
	 * 
	 * }
	 */

}


















/*
 * package com.tcs.boot.controller;
 * 
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpHeaders; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.MediaType; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.client.RestTemplate;
 * 
 * import com.tcs.boot.entity.Loan;
 * 
 * @RestController
 * 
 * @RequestMapping("/client/loan/api/v1.0") public class LoanController {
 * 
 * @Autowired RestTemplate template;
 * 
 * 
 * @Autowired LoanService service;
 * 
 * //http://localhost:9999//loan/api/v1.0/create
 * 
 * @PostMapping("/create") public Loan loanApplication(@RequestBody Loan loan) {
 * return service.addLoan(loan); }
 * 
 * @PostMapping(value="/create",consumes=MediaType.APPLICATION_JSON_VALUE,
 * produces=MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<Loan>
 * loanApplication(@RequestBody Loan loan) {
 * 
 * //return service.addLoan(loan); //return new
 * ResponseEntity<>(HttpStatus.CREATED);
 * 
 * //return new ResponseEntity<Loan>(newLoan,HttpStatus.OK);
 * 
 * HttpHeaders headers=new HttpHeaders();
 * 
 * headers.add("xx-created-by", "himaa"); headers.add("content-type",
 * "application/json");//MIME type //return new
 * ResponseEntity<Loan>(newLoan,headers,HttpStatus.OK); return
 * ResponseEntity.ok(newLoan); }
 * 
 * //http://localhost:9999//loan/api/v1.0/fetch/1
 * 
 * @GetMapping("/fetch/{id}") public Loan getLoan(@PathVariable Long id) {
 * return service.getLoan(id); }
 * 
 * @GetMapping("/fetch/{id}") public ResponseEntity<Loan> getLoan(@PathVariable
 * Long id) { //do this when id isn't found //return new
 * ResponseEntity<>(HttpStatus.BAD_REQUEST); //--set the values and send
 * //return ResponseEntity.status(400).body(null); //creating body set and send
 * static method
 * 
 * }
 * 
 * @GetMapping("/all") public List<Loan>getLoans(){ return null; }
 * 
 * @PutMapping("/modify") //for complete update public Loan
 * doUpdate(@RequestBody Loan loan ) { return null; }
 * 
 * @PutMapping("/modify2") //for complete update public Loan
 * doUpdate2(@RequestBody Loan loan ) { return null; }
 * 
 * 
 * @DeleteMapping("/remove/{id}") public void delete(@PathVariable Long id) {
 * service.remove(id); }
 * 
 * @DeleteMapping("/remove/{id}") public ResponseEntity<Void>
 * delete(@PathVariable Long id){ service.remove(id);
 * 
 * return null; }
 * 
 * 
 * //in Rest Controller
 * 
 * @ExceptionHandler(value = {IllegalArgumentException.class})
 * 
 * @ResponseStatus(HttpStatus.BAD_REQUEST) public
 * ResponseEntity<Map<String,String>> handleHandler(IllegalArgumentException
 * ex){ Map<String,String> errorMap = new HashMap<>();
 * 
 * errorMap.put("Loanid", ex.getMessage()); return
 * ResponseEntity.status(400).body(errorMap); }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */