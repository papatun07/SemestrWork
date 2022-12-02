//package dao;
//
//import Util.ConnectionProvider;
//import org.codehaus.plexus.components.io.fileselectors.FileInfo;
//import service.Impl.FilesServiceImpl;
//
//import javax.sql.DataSource;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Optional;
//
//public class FilesDao {
//    private ConnectionProvider connectionProvider;
//
//
//    private final static String SQL_INSERT = "insert into file_info(storage_file_name, original_file_name, type, size) " +
//            "values (?, ?, ?, ?)";
//    private final static String SQL_UPDATE = "update file_info set storage_file_name = ?, original_file_name = ?, type = ?, size = ? where id = ?";
//    private final static String SQL_SELECT_BY_ID = "select * from file_info where id = ?";
//
//
//    public FilesDao(ConnectionProvider connectionProvider) {
//        this.connectionProvider = connectionProvider;
//    }
//
////    private RowMapper<FileInfo> fileRowMapper = (row, rowNumber) ->
////            FileInfo.builder()
////                    .id(row.getLong("id"))
////                    .originalFileName(row.getString("original_file_name"))
////                    .storageFileName(row.getString("storage_file_name"))
////                    .size(row.getLong("size"))
////                    .type(row.getString("type"))
////                    .build();
//
//
//    public FileInfo save(FileInfo fileInfo) throws SQLException {
//        try {
//            PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("insert into file_info(original_file_name, storage_file_name, size, type) values (?,?,?,?)");
//            preparedStatement.setString(1, fileInfo.getStorageFileName());
//            preparedStatement.setString(1, fileInfo.getStorageFileName());
//            preparedStatement.setString(1, fileInfo.getStorageFileName());
//            preparedStatement.setString(1, fileInfo.getStorageFileName());
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            throw new IllegalArgumentException(e);
//        }
//    }
////        if(entity.getId() == null) {
////            KeyHolder keyHolder = new GeneratedKeyHolder();
////            jdbcTemplate.update(connection -> {
////                PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[]{"id"});
////                statement.setString(1, entity.getStorageFileName());
////                statement.setString(2, entity.getOriginalFileName());
////                statement.setString(3, entity.getType());
////                statement.setLong(4, entity.getSize());
////                return statement;
////            }, keyHolder);
////            entity.setId(keyHolder.getKey().longValue());
////        } else {
////            jdbcTemplate.update(SQL_UPDATE,
////                    entity.getStorageFileName(),
////                    entity.getOriginalFileName(),
////                    entity.getType(),
////                    entity.getSize(),
////                    entity.getId()
////            );
////        }
////        return entity;
//
//
//    public Optional<FileInfo> findById(Long id) {
//        try {
//            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, fileRowMapper, id));
//        } catch (EmptyResultDataAccessException e) {
//            return Optional.empty();
//        }
//    }
//
//    // TODO: Реализовать
//
//    public List<FileInfo> findAll() {
//        return null;
//    }
//
//    // TODO: Реализовать
//
//    public void delete(Long id) {}
//}
