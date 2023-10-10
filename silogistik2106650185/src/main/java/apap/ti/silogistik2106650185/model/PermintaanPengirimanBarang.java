package apap.ti.silogistik2106650185.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="permintaan_pengiriman_barang")
public class PermintaanPengirimanBarang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerintaanPengirimanBarang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="sku_barang", referencedColumnName="sku")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Barang barang;

    @ManyToOne(fetch = FetchType.EAGER, optional=false)
    @JoinColumn(name="id_permintaan_pengiriman", referencedColumnName="idPermintaanPengiriman")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PermintaanPengiriman permintaanPengiriman;

    @NotNull
    @Column(name="kuantitas_pengiriman", nullable = false)
    private int kuantitasPengiriman;
}
