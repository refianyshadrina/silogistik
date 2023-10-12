package apap.ti.silogistik2106650185;

import java.util.Locale;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import jakarta.transaction.Transactional;

import com.github.javafaker.Faker;

import apap.ti.silogistik2106650185.dto.BarangMapper;
import apap.ti.silogistik2106650185.dto.GudangMapper;
import apap.ti.silogistik2106650185.dto.KaryawanMapper;
import apap.ti.silogistik2106650185.dto.request.CreateGudangReqDTO;
import apap.ti.silogistik2106650185.dto.request.CreateKaryawanReqDTO;
import apap.ti.silogistik2106650185.service.BarangService;
import apap.ti.silogistik2106650185.service.GudangService;
import apap.ti.silogistik2106650185.service.KaryawanService;

@SpringBootApplication
public class Silogistik2106650185Application {

	public static void main(String[] args) {
		SpringApplication.run(Silogistik2106650185Application.class, args);
	}

	@Bean
	@Transactional
	CommandLineRunner run(GudangService gudangService, GudangMapper gudangMapper, KaryawanService karyawanService, KaryawanMapper karyawanMapper, BarangService barangService, BarangMapper barangMapper) {
		
		return args -> {
			var faker = new Faker(new Locale("in-ID"));
			Random random = new Random();

			for (int i = 0; i<1; i++) {
	
				// GUDANG
				var gudangDTO = new CreateGudangReqDTO();
				var fakeAddress = faker.address();
	
				int min = 1;
				int max = 100;
				var randomInteger = random.nextInt(max - min) + min;
	
				gudangDTO.setNama("Gudang - " + randomInteger + " " + fakeAddress.city());
				gudangDTO.setAlamatGudang(fakeAddress.streetAddress());
	
				var gudang = gudangMapper.createGudangReqDTOToGudang(gudangDTO);
				gudangService.saveGudang(gudang);
			
			}

			for (int i = 0; i<3; i++) {
				// KARYAWAN
				var karyawanDTO = new CreateKaryawanReqDTO();
				karyawanDTO.setNama(faker.name().fullName());
				karyawanDTO.setJenisKelamin(random.nextInt(2-1) + 1);
				karyawanDTO.setTanggalLahir(faker.date().birthday());

				var karyawan = karyawanMapper.createKaryawanReqDTOToKaryawan(karyawanDTO);
				karyawanService.saveKaryawan(karyawan);

				// BARANG
				// var barangDTO = new CreateBarangReqDTO();
				// var tipeBarang = random.nextInt(5-1) + 1;
				// var sku = "";
				// switch (tipeBarang) {
				// 	case 1:
				// 		sku = "ELEC";
				// 		break;
				// 	case 2:
				// 		sku = "CLOT";
				// 		break;
				// 	case 3:
				// 		sku = "FOOD";
				// 		break;
				// 	case 4:
				// 		sku = "COSM";
				// 		break;
				// 	case 5:
				// 		sku = "TOOL";
				// 		break;
				// }
				// int random_number = random.nextInt(999) + 1;
				// DecimalFormat decimalFormat = new DecimalFormat("00");
				// String formatted_number = decimalFormat.format(random_number);

				// sku += formatted_number;
				// sku = "ELEC001";
				// var merk = faker.commerce().productName();
				// var harga = 1000L + (long) (random.nextDouble() * (100000L - 1000L));

				// barangDTO.setSku(sku);
				// barangDTO.setTipeBarang(tipeBarang);
				// barangDTO.setMerk(merk);
				// barangDTO.setHargaBarang(harga);

				// var barang = barangMapper.createBarangReqDTOToBarang(barangDTO);
				// barangService.saveBarang(barang);
			


			}
		};
	}

}
