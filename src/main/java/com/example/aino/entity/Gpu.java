package com.example.aino.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "gpu")
@Entity
public class Gpu {
    @Id
    /*trường id cứ là số thì tự động tăng hết kẻo lại gặp lỗi phải đặt id trước khi persist (ko cần biết trong db có đặt
    identity hay là ko, còn ko phải số thì hoặc là đặt thủ công hoặc gọi ra từ api*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_so")
    private Integer maSo;
    @Column(name = "hang_san_xuat")
    private String hangSanXuat;
    @Column(name = "xung_nhip_toi_thieu")
    private Integer xungNhipToiThieu;
    @Column(name = "xung_nhip_toi_da")
    private Integer xungNhipToiDa;
    @Column(name = "vram")
    private Integer vram;
    @Column(name = "dien_ap")
    private Integer dienAp;
    @Column(name = "kien_truc_cong_nghe")
    private String kienTrucCongNghe;
    @Column(name = "ten")
    private String ten;
    @OneToOne
    @JoinColumn(name = "ma_so")
    private SanPham sanPham;
}
