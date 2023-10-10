package apap.ti.silogistik2106650185.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="gudang_barang")
public class GudangBarang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGudangBarang;

    @ManyToOne(fetch = FetchType.EAGER, optional=false)
    @JoinColumn(name="sku_barang", referencedColumnName="sku")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Barang barang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_gudang", referencedColumnName="idGudang")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Gudang gudang;

    @NotNull
    @Column(name="stok", nullable = false)
    private int stok;



}
